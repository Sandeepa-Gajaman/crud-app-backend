package com.sandeepa.crudapp.service;

import com.sandeepa.crudapp.dto.SchoolDto;
import com.sandeepa.crudapp.entities.SchoolEntity;
import com.sandeepa.crudapp.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
