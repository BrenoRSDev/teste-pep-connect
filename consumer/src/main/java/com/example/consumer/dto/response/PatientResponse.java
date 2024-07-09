package com.example.consumer.dto.response;

import java.time.LocalDate;

public record PatientResponse(Long id, Long code, String name, String cpf, LocalDate birthDate) {
}
