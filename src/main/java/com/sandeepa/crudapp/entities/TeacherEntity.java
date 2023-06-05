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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private ClassEntity aClass;

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
}
