package com.uninassau.fluxoescolar.fluxo.services;

import com.uninassau.fluxoescolar.fluxo.dtos.StudentDTO;
import com.uninassau.fluxoescolar.fluxo.models.Student;
import org.springframework.data.domain.Page;

public interface StudentService {

    Student findById(Long id);

    StudentDTO save(StudentDTO dto);

    void delete(Long id);

    Page<Student> search(String status, Integer page, Integer linesPerPage, String orderBy, String direction);

    StudentDTO toDto(Student entity);

    Student toEntity(StudentDTO dto);

}