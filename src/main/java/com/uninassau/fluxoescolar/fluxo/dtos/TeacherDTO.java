package com.uninassau.fluxoescolar.fluxo.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDTO {

    private Long id;

    private String name;

    private String course;

    private String status;
}
