package com.example.consumer.controller;

import com.example.consumer.dto.response.PatientResponse;
import com.example.consumer.filter.PatientFilter;
import com.example.consumer.model.Patient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface PatientControllerOpenApi {

    @Operation(summary = "Lista pacientes.", method = "GET")
    @ApiResponses({
            @ApiResponse(responseCode = "200",content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = PatientResponse.class)) }, description = "Requisição com sucesso"),
            @ApiResponse(responseCode = "404", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Object.class)) }, description = "O recurso não foi encontrado") })
    @GetMapping
    ResponseEntity<Page<PatientResponse>> list(@ParameterObject Pageable pageable, @ParameterObject PatientFilter filter);

}
