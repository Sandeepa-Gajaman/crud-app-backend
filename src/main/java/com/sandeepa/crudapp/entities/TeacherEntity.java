package com.sandeepa.crudapp.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "teacher")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull private String name;
    @NonNull private LocalDate dob;

    @Transient
    private Integer age;

    @OneToOne(mappedBy = "teacher")
    private ClassEntity aClass;

    @ManyToOne
    @JoinColumn(name = "school_fk", referencedColumnName = "id")
    private SchoolEntity teacherSchool;

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
}
