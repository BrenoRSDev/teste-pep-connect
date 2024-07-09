package com.example.consumer.repository;

import com.example.consumer.model.Patient;
import com.example.consumer.repository.filter.PatientRepositoryFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>, PatientRepositoryFilter {
}
