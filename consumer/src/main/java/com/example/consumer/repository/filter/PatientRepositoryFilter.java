package com.example.consumer.repository.filter;

import com.example.consumer.filter.PatientFilter;
import com.example.consumer.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PatientRepositoryFilter {

    Page<Patient> findAll(PatientFilter filter, Pageable pageable);
}
