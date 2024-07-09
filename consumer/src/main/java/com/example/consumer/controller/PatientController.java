package com.example.consumer.controller;

import com.example.consumer.dto.response.PatientResponse;
import com.example.consumer.filter.PatientFilter;
import com.example.consumer.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/patient")
@AllArgsConstructor
public class PatientController implements PatientControllerOpenApi {

    PatientService patientService;

    @Override
    public ResponseEntity<Page<PatientResponse>> list(Pageable pageable, PatientFilter filter) {
        return ResponseEntity.ok(patientService.findAll(pageable, filter));
    }
}
