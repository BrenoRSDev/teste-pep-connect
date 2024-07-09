package com.example.consumer.service;


import com.example.consumer.consumer.event.PatientEvent;
import com.example.consumer.dto.response.PatientResponse;
import com.example.consumer.filter.PatientFilter;
import com.example.consumer.mapper.PatientMapper;
import com.example.consumer.model.Patient;
import com.example.consumer.repository.PatientRepository;
import com.example.consumer.repository.filter.PatientRepositoryFilter;
import com.example.consumer.service.impl.PatientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PatientServiceImplTest {

    @Mock
    private PatientRepository repository;

//    @Mock
//    private PatientRepositoryFilter repositoryFilter;

    @Mock
    private PatientMapper mapper;

    @InjectMocks
    private PatientServiceImpl service;

    private List<Patient> patients;

    @BeforeEach
    public void setUp() {
        patients = new ArrayList<>();
        Patient model = new Patient();
        model.setCode(1L);
        model.setName("Paciente 0");
        model.setCpf("03368837060");
        model.setBirthDate(LocalDate.now());

        patients.add(model);
    }

    @Test
    @DisplayName("deve buscar pacientes sem filtro com sucesso")
    public void shouldFindAllWithSucess() {
        //Arrange
        Pageable pageable = PageRequest.of(0, 10);
        Page<Patient> patientPage = new PageImpl<>(patients, pageable, patients.size());

        PatientFilter patientFilter = new PatientFilter("Paciente 0", null, null);

        when(repository.findAll(patientFilter, pageable)).thenReturn(patientPage);

        //Act
        Page<PatientResponse> result = service.findAll(pageable, patientFilter);

        //Assert
        assertEquals(patients.size(), result.getContent().size());
    }

    @Test
    @DisplayName("deve salvar paciente com sucesso")
    public void shouldSaveWithSucess() {
        //Arrange
        LocalDate date = LocalDate.now();
        PatientEvent event = new PatientEvent(1L, "Paciente 0", "03368837060", date);
        Patient model = new Patient();
        model.setCode(1L);
        model.setName("Paciente 0");
        model.setCpf("03368837060");
        model.setBirthDate(date);


        when(mapper.eventToModel(event)).thenReturn(model);
        when(repository.save(model)).thenReturn(model);

        //Act
        Patient result = service.save(event);

        //Assert
        verify(mapper).eventToModel(event);
        verify(repository).save(model);
    }

}
