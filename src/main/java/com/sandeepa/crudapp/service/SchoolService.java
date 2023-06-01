package com.sandeepa.crudapp.service;

import com.sandeepa.crudapp.dto.SchoolDto;
import com.sandeepa.crudapp.dto.StudentDto;
import com.sandeepa.crudapp.entities.SchoolEntity;
import com.sandeepa.crudapp.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    public List<SchoolDto> getSchoolDetails() {
        List<SchoolEntity> schoolEntities = schoolRepository.findAll();
        List<SchoolDto> schoolDetails = new ArrayList<>();

        for (SchoolEntity schoolEntity : schoolEntities) {
            SchoolDto dto = new SchoolDto();
            dto.setSchoolName(schoolEntity.getName());
            dto.setSchoolAddress(schoolEntity.getAddress());
            schoolDetails.add(dto);
        }

        return schoolDetails;
    }

    public SchoolDto getSchoolById(Long schoolId) {
        SchoolEntity school = schoolRepository.findById(schoolId)
                .orElseThrow(() -> new IllegalStateException("School with " + schoolId + " id not found!"));

        List<StudentDto> studentDtos = school.getStudents().stream()
                .map(student -> new StudentDto(student.getName(),student.getEmail(),
                        student.getDob(), student.getAge()))
                .collect(Collectors.toList());

        return new SchoolDto(school.getName(), school.getAddress(), studentDtos);

    }
}
