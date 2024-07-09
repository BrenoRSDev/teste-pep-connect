package com.example.consumer.mapper;

import com.example.consumer.consumer.event.PatientEvent;
import com.example.consumer.dto.response.PatientResponse;
import com.example.consumer.model.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class PatientMapperTest {

    @InjectMocks
    private PatientMapper patientMapper;

    @Test
    @DisplayName("Deve Mapear PacientEvent para Pacient com sucesso")
    void shouldMapPacientEventToPacientModel(){
        //Arrange
        LocalDate date = LocalDate.now();
        PatientEvent event = new PatientEvent(1L, "Paciente 001", "03368837060", date);

        //Act
        Patient model = patientMapper.eventToModel(event);

        //Assert
        Assertions.assertNotNull(model);
        Assertions.assertEquals(event.code(), model.getCode());
        Assertions.assertEquals(event.name(), model.getName());
        Assertions.assertEquals(event.cpf(), model.getCpf());
        Assertions.assertEquals(event.birthDate(), model.getBirthDate());
    }

    @Test
    @DisplayName("Deve Mapear Pacient para PacientResponse com sucesso")
    void shouldMapPacientModelToPacientResponse(){
        //Arrange
        Patient model = new Patient();
        model.setId(1L);
        model.setCode(1L);
        model.setName("Paciente 0");
        model.setCpf("03368837060");
        model.setBirthDate(LocalDate.now());

        //Act
        PatientResponse response = patientMapper.modelToResponse(model);

        //Assert
        Assertions.assertNotNull(model);
        Assertions.assertEquals(response.code(), model.getCode());
        Assertions.assertEquals(response.name(), model.getName());
        Assertions.assertEquals(response.cpf(), model.getCpf());
        Assertions.assertEquals(response.birthDate(), model.getBirthDate());
    }
}
