package com.uninassau.fluxoescolar.fluxo.services.impl;

import com.uninassau.fluxoescolar.fluxo.dtos.ClassRoomDTO;
import com.uninassau.fluxoescolar.fluxo.exceptions.ResourceNotFoundException;
import com.uninassau.fluxoescolar.fluxo.models.ClassRoom;
import com.uninassau.fluxoescolar.fluxo.repositories.ClassRoomRepository;
import com.uninassau.fluxoescolar.fluxo.services.ClassRoomService;
import lombok.RequiredArgsConstructor;
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

        return toDto(repository.save(classRooom));
    }


    @Override
    public ClassRoom update(ClassRoomDTO dto) {
        return null;
    }

    @Override
    public ClassRoomDTO toDto(ClassRoom entity) {
        var dto = new ClassRoomDTO();
        dto.setId(entity.getId());
        dto.setClassName(entity.getClassName());
        dto.setTeacher(entity.getTeacher());
        dto.setStudent(entity.getStudent());
        dto.setStartTime(entity.getStartTime());
        dto.setEndTime(entity.getEndTime());
        return dto;
    }

    @Override
    public ClassRoom toEntity(ClassRoomDTO dto) {
        var entity = new ClassRoom();
        entity.setId(dto.getId());
        entity.setClassName(dto.getClassName());
        entity.setTeacher(dto.getTeacher());
        entity.setStudent(dto.getStudent());
        entity.setStartTime(dto.getStartTime());
        entity.setEndTime(dto.getEndTime());
        return entity;
    }
}
