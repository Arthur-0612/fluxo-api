package com.uninassau.fluxoescolar.fluxo.services;

import com.uninassau.fluxoescolar.fluxo.dtos.ClassRoomDTO;
import com.uninassau.fluxoescolar.fluxo.models.ClassRoom;

public interface ClassRoomService {

    ClassRoom findById(Long id);

    ClassRoomDTO save(ClassRoomDTO dto);

    ClassRoom update(ClassRoomDTO dto);

    ClassRoomDTO toDto(ClassRoom entity);

    ClassRoom toEntity(ClassRoomDTO dto);

}
