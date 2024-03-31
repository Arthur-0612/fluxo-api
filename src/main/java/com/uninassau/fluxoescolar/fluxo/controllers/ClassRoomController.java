package com.uninassau.fluxoescolar.fluxo.controllers;


import com.uninassau.fluxoescolar.fluxo.dtos.ClassRoomDTO;
import com.uninassau.fluxoescolar.fluxo.repositories.ClassRoomRepository;
import com.uninassau.fluxoescolar.fluxo.services.ClassRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/classroom")
@RequiredArgsConstructor
public class ClassRoomController {

    private final ClassRoomService service;

    @PostMapping("/save")
    public ResponseEntity<ClassRoomDTO> save(@RequestBody ClassRoomDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.save(dto));
    }

}
