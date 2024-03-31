package com.uninassau.fluxoescolar.fluxo.repositories;

import com.uninassau.fluxoescolar.fluxo.models.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRoomRepository extends JpaRepository <ClassRoom, Long> {
}