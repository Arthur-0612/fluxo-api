package com.uninassau.fluxoescolar.fluxo.controllers;

import com.uninassau.fluxoescolar.fluxo.dtos.StudentDTO;
import com.uninassau.fluxoescolar.fluxo.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @PostMapping("/save")
    public ResponseEntity<StudentDTO> save(@RequestBody StudentDTO dto ){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

}
