package com.sandeepa.crudapp.controller;

import com.sandeepa.crudapp.dto.SchoolDto;
import com.sandeepa.crudapp.dto.StudentDto;
import com.sandeepa.crudapp.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/school")
public class SchoolController {

    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping
    public List<SchoolDto> getSchoolDetails() {
        return schoolService.getSchoolDetails();
    }

    @GetMapping(path = "/{schoolId}")
    public ResponseEntity<SchoolDto> getSchoolById(@PathVariable Long schoolId) {
        SchoolDto schoolById = schoolService.getSchoolById(schoolId);
        return ResponseEntity.ok(schoolById);
    }

}
