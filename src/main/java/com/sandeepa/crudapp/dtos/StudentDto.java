package com.sandeepa.crudapp.dtos;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class StudentDto {
    @NonNull private String name;
    @NonNull private String email;
    @NonNull private LocalDate dob;
    @NonNull private Integer age;
    private String schoolName;
    @NonNull private String className;
}
