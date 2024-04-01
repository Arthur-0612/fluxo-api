package com.uninassau.fluxoescolar.fluxo.dtos;

import com.uninassau.fluxoescolar.fluxo.models.ClassRoom;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentDTO {

    private Long id;

    private String name;

    private LocalDate birthDate;

    private Integer registrationNumber;

    private String gender;

    private double monthlyFee;

    private String status;
}
