package com.sandeepa.crudapp.repositories;

import com.sandeepa.crudapp.entities.ClassEntity;
import com.sandeepa.crudapp.entities.SchoolEntity;
import com.sandeepa.crudapp.entities.StudentEntity;
import com.sandeepa.crudapp.entities.TeacherEntity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.time.Month.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    @Test
    void canFindStudentByEmail() {
        // given
        StudentEntity student = new StudentEntity();
        student.setName("Annabeth");
        student.setEmail("annabeth@gmail.com");
        student.setDob(LocalDate.of(1997, JANUARY,01));

        underTest.save(student);

        // when
        Optional<StudentEntity> expected = underTest.findStudentByEmail(student.getEmail());

        // then
        assertThat(expected).isPresent(); // Check if the Optional is present
        assertThat(expected.get().getEmail()).isEqualTo("annabeth@gmail.com"); // Check if the retrieved email matches the expected value
    }

    @Test
    @Disabled
    void searchStudentByKeyword() {

    }
}