package com.uninassau.fluxoescolar.fluxo.services.impl;

import com.uninassau.fluxoescolar.fluxo.dtos.TeacherDTO;
import com.uninassau.fluxoescolar.fluxo.exceptions.ResourceNotFoundException;
import com.uninassau.fluxoescolar.fluxo.models.Teacher;
import com.uninassau.fluxoescolar.fluxo.repositories.TeacherRepository;
import com.uninassau.fluxoescolar.fluxo.services.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository repository;

    @Override
    public Teacher findById(Long id) {
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Teacher not found!"));
    }

    @Override
    public TeacherDTO save(TeacherDTO dto) {
        var teacher = toEntity(dto);
        teacher.setStatus("A");
        return toDto(repository.save(teacher));
    }

    @Override
    public void delete(Long id) {
        var teacher = findById(id);
        teacher.setStatus("I");
        repository.save(teacher);
    }

    @Override
    public Page<Teacher> search(String status, Integer page, Integer linesPerPage, String orderBy, String direction) {
        Pageable pageable = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        if(status.isEmpty()){
            return repository.findAll(pageable);
        }
        return repository.findByStatus(status, pageable);
    }

    @Override
    public TeacherDTO toDto(Teacher entity) {
        var dto = new TeacherDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCourse(entity.getCourse());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    @Override
    public Teacher toEntity(TeacherDTO dto) {
        var entity = new Teacher();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCourse(dto.getCourse());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
