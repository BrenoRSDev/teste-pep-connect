package com.example.consumer.filter;

import java.time.LocalDate;

public record PatientFilter(String name, String cpf, LocalDate birthDate) {
}
