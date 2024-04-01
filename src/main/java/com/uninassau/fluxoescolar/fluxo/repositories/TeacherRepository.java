package com.uninassau.fluxoescolar.fluxo.repositories;

import com.uninassau.fluxoescolar.fluxo.models.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {

    @Query("SELECT DISTINCT obj FROM Teacher obj WHERE obj.status = :status")
    Page<Teacher> findByStatus(@Param("status") String status, Pageable pageable);
}
