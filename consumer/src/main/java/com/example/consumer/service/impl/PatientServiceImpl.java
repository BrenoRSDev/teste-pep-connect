package com.example.consumer.service.impl;

import com.example.consumer.consumer.event.PatientEvent;
import com.example.consumer.dto.response.PatientResponse;
import com.example.consumer.filter.PatientFilter;
import com.example.consumer.mapper.PatientMapper;
import com.example.consumer.model.Patient;
import com.example.consumer.repository.PatientRepository;
import com.example.consumer.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private PatientRepository repository;
    private PatientMapper mapper;

    @Override
    public Page<PatientResponse> findAll(Pageable pageable, PatientFilter filter){
        System.out.println(pageable);
        System.out.println(filter);
        Page<Patient> model = repository.findAll(filter, pageable);
        return model.map(mapper::modelToResponse);
    }

    @Transactional
    @Override
    public Patient save(PatientEvent event){
        Patient model = mapper.eventToModel(event);
        return repository.save(model);
    }
}
