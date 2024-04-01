package com.uninassau.fluxoescolar.fluxo.controllers;

import com.uninassau.fluxoescolar.fluxo.dtos.TeacherDTO;
import com.uninassau.fluxoescolar.fluxo.models.Teacher;
import com.uninassau.fluxoescolar.fluxo.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService service;

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> findById(@PathVariable Long id){
        var teacher = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(service.toDto(teacher));
    }

    @PostMapping("/save")
    public ResponseEntity<TeacherDTO> save(@RequestBody TeacherDTO teacherDTO){
        return ResponseEntity.status(HttpStatus.OK).body(service.save(teacherDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/page")
    public ResponseEntity<Page<TeacherDTO>> search(
            @RequestParam(value="status", defaultValue="") String status,
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="10") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="name") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction){
        Page<Teacher> list = service.search(status, page, linesPerPage, orderBy, direction);
        Page<TeacherDTO> listDto =list.map(service::toDto);

        return ResponseEntity.status(HttpStatus.OK).body(listDto);
    }

}
