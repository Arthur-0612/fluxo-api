package com.uninassau.fluxoescolar.fluxo.repositories;

import com.uninassau.fluxoescolar.fluxo.models.Student;
import com.uninassau.fluxoescolar.fluxo.models.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT DISTINCT obj FROM Student obj WHERE obj.status = :status")
    Page<Student> findByStatus(@Param("status") String status, Pageable pageable);

}
