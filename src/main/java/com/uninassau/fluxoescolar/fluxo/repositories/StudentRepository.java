package com.uninassau.fluxoescolar.fluxo.repositories;

import com.uninassau.fluxoescolar.fluxo.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {
}
