package com.sandeepa.crudapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDto {
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;
}
