package com.uninassau.fluxoescolar.fluxo.services.impl;

import com.uninassau.fluxoescolar.fluxo.dtos.StudentDTO;
import com.uninassau.fluxoescolar.fluxo.exceptions.ResourceNotFoundException;
import com.uninassau.fluxoescolar.fluxo.models.Student;
import com.uninassau.fluxoescolar.fluxo.repositories.StudentRepository;
import com.uninassau.fluxoescolar.fluxo.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    @Override
    public Student findById(Long id) {
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student Not Found!"));
        }

    @Override
    public StudentDTO save(StudentDTO dto) {

        var student = toEntity(dto);

        return toDto(repository.save(student));
    }

    @Override
    public Student update(StudentDTO dto) {
        return null;
    }

    @Override
    public StudentDTO toDto(Student entity) {
        var dto = new StudentDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setGender(entity.getGender());
        dto.setBirthDate(entity.getBirthDate());
        dto.setMonthlyFee(entity.getMonthlyFee());
        dto.setRegistrationNumber(entity.getRegistrationNumber());
        return dto;
    }

    @Override
    public Student toEntity(StudentDTO dto) {
        var entity = new Student();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setGender(dto.getGender());
        entity.setBirthDate(dto.getBirthDate());
        entity.setMonthlyFee(dto.getMonthlyFee());
        entity.setRegistrationNumber(dto.getRegistrationNumber());
        return entity;
    }
}
