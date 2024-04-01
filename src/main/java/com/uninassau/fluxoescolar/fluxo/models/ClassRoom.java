package com.uninassau.fluxoescolar.fluxo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "ClassRoom")
@Getter
@Setter
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String className;

    private LocalTime startTime;

    private LocalTime endTime;

    private String status;

    @ManyToMany
    @JoinTable(name = "classRoom_students", joinColumns =
            {@JoinColumn(name = "classRoom_id")},
            inverseJoinColumns =
            {@JoinColumn(name = "student_id")})
    private List<Student> students;

    @ManyToOne
    private Teacher teacher;
}
