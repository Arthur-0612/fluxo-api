package com.uninassau.fluxoescolar.fluxo.dtos;

import com.uninassau.fluxoescolar.fluxo.models.Student;
import com.uninassau.fluxoescolar.fluxo.models.Teacher;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class ClassRoomDTO {

    private Long id;

    private String className;

    private LocalTime startTime;

    private LocalTime endTime;

    private String status;

    private List<Student> students;

    private Teacher teacher;


}
