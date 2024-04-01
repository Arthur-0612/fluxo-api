package com.uninassau.fluxoescolar.fluxo.services;

import com.uninassau.fluxoescolar.fluxo.dtos.TeacherDTO;
import com.uninassau.fluxoescolar.fluxo.models.Teacher;
import org.springframework.data.domain.Page;


public interface TeacherService {

    Teacher findById(Long id);

    TeacherDTO save(TeacherDTO dto);

    void delete(Long id);

    Page<Teacher> search(String status, Integer page, Integer linesPerPage, String orderBy, String direction);

    TeacherDTO toDto(Teacher entity);

    Teacher toEntity(TeacherDTO dto);
}
