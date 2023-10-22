package com.sandeepa.crudapp.services;

import com.sandeepa.crudapp.entities.StudentEntity;
import com.sandeepa.crudapp.repositories.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static java.time.Month.JANUARY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class) // Can remove the commented lines if using this
class StudentServiceTest {

    @Mock private StudentRepository studentRepository;
//    private AutoCloseable autoCloseable;
    private StudentService underTest;

    @BeforeEach
    void setUp() {
//        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new StudentService(studentRepository);
    }

//    @AfterEach
//    void tearDown() throws Exception {
//        autoCloseable.close();
//    }

    @Test
    void canGetStudents() {
        // when
        underTest.getStudents();
        // then
        verify(studentRepository).findAll();

    }

    @Test
    void willThrowExceptionWhenEmailIsTaken() {
        // given
        StudentEntity student = new StudentEntity();
        student.setName("Annabeth");
        student.setEmail("annabeth@gmail.com");
        student.setDob(LocalDate.of(1997, JANUARY,01));

        String studentOptional = "annabeth@gmail.com";

        given(studentRepository.findStudentByEmail(student.getEmail()))
                .willReturn(Optional.of(student));

        // when
        // then
        assertThatThrownBy(() -> underTest.addNewStudent(student))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Email already exists!");

        verify(studentRepository, never()).save(any());
    }

    @Test
    void canAddNewStudent() {
        // given
        StudentEntity student = new StudentEntity();
        student.setName("Annabeth");
        student.setEmail("annabeth@gmail.com");
        student.setDob(LocalDate.of(1997, JANUARY,01));

        // when
        underTest.addNewStudent(student);

        // then
        ArgumentCaptor<StudentEntity> studentEntityArgumentCaptor = ArgumentCaptor.forClass(StudentEntity.class);

        verify(studentRepository).save(studentEntityArgumentCaptor.capture());

        StudentEntity captureStudent = studentEntityArgumentCaptor.getValue();

        assertThat(captureStudent).isEqualTo(student);

    }

}