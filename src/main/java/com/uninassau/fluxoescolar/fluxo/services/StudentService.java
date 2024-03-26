package com.uninassau.fluxoescolar.fluxo.services;

import com.uninassau.fluxoescolar.fluxo.dtos.StudentDTO;
import com.uninassau.fluxoescolar.fluxo.models.Student;

public interface StudentService {

    Student findById(Long id);

    StudentDTO save(StudentDTO dto);

    Student update(StudentDTO dto);

    StudentDTO toDto(Student entity);

    Student toEntity(StudentDTO dto);

}