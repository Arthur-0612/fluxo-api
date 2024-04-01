package com.uninassau.fluxoescolar.fluxo.services.impl;

import com.uninassau.fluxoescolar.fluxo.dtos.ClassRoomDTO;
import com.uninassau.fluxoescolar.fluxo.exceptions.ResourceNotFoundException;
import com.uninassau.fluxoescolar.fluxo.models.ClassRoom;
import com.uninassau.fluxoescolar.fluxo.repositories.ClassRoomRepository;
import com.uninassau.fluxoescolar.fluxo.services.ClassRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassRoomServiceImpl implements ClassRoomService {

    private final ClassRoomRepository repository;

    @Override
    public ClassRoom findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ClassRoom not found!"));
    }

    @Override
    public ClassRoomDTO save(ClassRoomDTO dto) {
        var classRooom = toEntity(dto);
        classRooom.setStatus("A");
        return toDto(repository.save(classRooom));
    }

    @Override
    public void delete(Long id) {
        var classroom =findById(id);
        classroom.setStatus("I");
        repository.save(classroom);
    }

    @Override
    public Page<ClassRoom> search(String status, Integer page, Integer linesPerPage, String orderBy, String direction){
        Pageable pageable = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), "className");

        if(status.isEmpty()){
            return repository.findAll(pageable);
        }
        return repository.findByStatus(status, pageable);
    }

    @Override
    public ClassRoomDTO toDto(ClassRoom entity) {
        var dto = new ClassRoomDTO();
        dto.setId(entity.getId());
        dto.setClassName(entity.getClassName());
        dto.setTeacher(entity.getTeacher());
        dto.setStudents(entity.getStudents());
        dto.setStartTime(entity.getStartTime());
        dto.setEndTime(entity.getEndTime());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    @Override
    public ClassRoom toEntity(ClassRoomDTO dto) {
        var entity = new ClassRoom();
        entity.setId(dto.getId());
        entity.setClassName(dto.getClassName());
        entity.setTeacher(dto.getTeacher());
        entity.setStudents(dto.getStudents());
        entity.setStartTime(dto.getStartTime());
        entity.setEndTime(dto.getEndTime());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
