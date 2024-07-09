package com.example.consumer.mapper;

import com.example.consumer.consumer.event.PatientEvent;
import com.example.consumer.dto.response.PatientResponse;
import com.example.consumer.model.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public Patient eventToModel(PatientEvent event) {
        Patient patient = new Patient();
        patient.setCode(event.code());
        patient.setCpf(event.cpf());
        patient.setName(event.name());
        patient.setBirthDate(event.birthDate());
        return patient;
    }

    public PatientResponse modelToResponse(Patient model){
        return new PatientResponse(model.getId(), model.getCode(),
                model.getName(), model.getCpf(), model.getBirthDate());
    }
}
