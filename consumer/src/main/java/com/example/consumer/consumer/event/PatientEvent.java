package com.example.consumer.consumer.event;

import java.io.Serializable;
import java.time.LocalDate;

public record PatientEvent(Long code, String name, String cpf, LocalDate birthDate) implements Serializable {
}
