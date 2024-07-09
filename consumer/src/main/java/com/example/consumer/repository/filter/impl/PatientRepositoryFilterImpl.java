package com.example.consumer.repository.filter.impl;

import com.example.consumer.filter.PatientFilter;
import com.example.consumer.model.Patient;
import com.example.consumer.repository.filter.PatientRepositoryFilter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.query.QueryUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;


@Repository
public class PatientRepositoryFilterImpl implements PatientRepositoryFilter {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Patient> findAll(PatientFilter filter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Patient> criteriaQuery = builder.createQuery(Patient.class);
        Root<Patient> root = criteriaQuery.from(Patient.class);
        List<Predicate> predicates = getPridicates(filter, builder, root);

        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        criteriaQuery.orderBy(QueryUtils.toOrders(pageable.getSort(), root, builder));
        TypedQuery<Patient> query = manager.createQuery(criteriaQuery);
        query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        query.setMaxResults(pageable.getPageSize());

        return new PageImpl<>(query.getResultList(), pageable, getTotalCount(filter, builder));
    }

    private List<Predicate> getPridicates(PatientFilter filter, CriteriaBuilder builder, Root<Patient> root){
        List<Predicate> predicates = new ArrayList<>();
        if(nonNull(filter)) {
            if (nonNull(filter.name())) {
                predicates.add(builder.like(builder.lower(root.get("name")), "%" + filter.name().toLowerCase() + "%"));
            }
            if (nonNull(filter.cpf())) {
                predicates.add(builder.equal(root.get("cpf"), filter.cpf()));
            }
            if (nonNull(filter.birthDate())) {
                predicates.add(builder.equal(root.get("birthDate"), filter.birthDate()));
            }
        }
        return predicates;
    }
    private Long getTotalCount(PatientFilter filter, CriteriaBuilder builder) {
        CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
        Root<Patient> root = criteriaQuery.from(Patient.class);

        criteriaQuery.select(builder.count(root));
        criteriaQuery.where(getPridicates(filter, builder, root).toArray(new Predicate[0]));
        return manager.createQuery(criteriaQuery).getSingleResult();
    }
}
