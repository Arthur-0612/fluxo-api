package com.uninassau.fluxoescolar.fluxo.services;

import com.uninassau.fluxoescolar.fluxo.dtos.ClassRoomDTO;
import com.uninassau.fluxoescolar.fluxo.models.ClassRoom;
import org.springframework.data.domain.Page;

public interface ClassRoomService {

    ClassRoom findById(Long id);

    ClassRoomDTO save(ClassRoomDTO dto);

    void delete(Long id);

    Page<ClassRoom> search(String status, Integer page, Integer linesPerPage, String orderBy, String direction);

    ClassRoomDTO toDto(ClassRoom entity);

    ClassRoom toEntity(ClassRoomDTO dto);

}
