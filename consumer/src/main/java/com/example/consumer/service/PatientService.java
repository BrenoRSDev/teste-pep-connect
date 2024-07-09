package com.example.consumer.service;

import com.example.consumer.consumer.event.PatientEvent;
import com.example.consumer.dto.response.PatientResponse;
import com.example.consumer.filter.PatientFilter;
import com.example.consumer.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PatientService {

    Page<PatientResponse> findAll(Pageable pageable, PatientFilter filter);

    Patient save(PatientEvent event);
}
