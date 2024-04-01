package com.uninassau.fluxoescolar.fluxo.repositories;

import com.uninassau.fluxoescolar.fluxo.models.ClassRoom;
import com.uninassau.fluxoescolar.fluxo.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClassRoomRepository extends JpaRepository <ClassRoom, Long> {

    @Query("SELECT DISTINCT obj FROM ClassRoom obj WHERE obj.status = :status")
    Page<ClassRoom> findByStatus(@Param("status") String status, Pageable pageable);
}