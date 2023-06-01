package com.sandeepa.crudapp.controller;

import com.sandeepa.crudapp.dto.SchoolDto;
import com.sandeepa.crudapp.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
