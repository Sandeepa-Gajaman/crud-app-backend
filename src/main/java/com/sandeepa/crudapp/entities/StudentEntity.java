package com.sandeepa.crudapp.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "student")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class StudentEntity {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private Long id;
    @NonNull private String name;
    @NonNull private String email;
    @NonNull private LocalDate dob;

    @Transient
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "school_id", referencedColumnName = "id")
    private SchoolEntity studentSchool;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private ClassEntity aClass;

    //Calculate student's age
    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

}
