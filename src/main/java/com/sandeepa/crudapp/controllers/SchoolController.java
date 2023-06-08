package com.sandeepa.crudapp.controllers;

import com.sandeepa.crudapp.dtos.SchoolDto;
import com.sandeepa.crudapp.services.SchoolService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/school")
@AllArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    /*
    @AllArgsConstructor creates this constructor. @Autowired not necessary in this scenario.

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

     */

    @GetMapping
    public List<SchoolDto> getSchoolDetails() {
        return schoolService.getSchoolDetails();
    }

    @GetMapping(path = "{schoolId}")
    public ResponseEntity<SchoolDto> getSchoolById(@PathVariable Long schoolId) {
        SchoolDto schoolById = schoolService.getSchoolByIdWithStudents(schoolId);
        return ResponseEntity.ok(schoolById);
    }

}
