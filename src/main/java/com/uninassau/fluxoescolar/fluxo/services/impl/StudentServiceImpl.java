package com.uninassau.fluxoescolar.fluxo.services.impl;

import com.uninassau.fluxoescolar.fluxo.dtos.StudentDTO;
import com.uninassau.fluxoescolar.fluxo.exceptions.ResourceNotFoundException;
import com.uninassau.fluxoescolar.fluxo.models.Student;
import com.uninassau.fluxoescolar.fluxo.repositories.StudentRepository;
import com.uninassau.fluxoescolar.fluxo.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        student.setStatus("A");
        return toDto(repository.save(student));
    }

    @Override
    public void delete(Long id) {
        var student = findById(id);
        student.setStatus("I");
        repository.save(student);
    }

    @Override
    public Page<Student> search(String status, Integer page, Integer linesPerPage, String orderBy, String direction){
        Pageable pageable = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        if(status.isEmpty()){
            return repository.findAll(pageable);
        }
        return  repository.findByStatus(status, pageable);
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
