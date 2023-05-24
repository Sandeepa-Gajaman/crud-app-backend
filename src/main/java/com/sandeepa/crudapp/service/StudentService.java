package com.sandeepa.crudapp.service;

import com.sandeepa.crudapp.dto.StudentDto;
import com.sandeepa.crudapp.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<StudentDto> getStudents() {

        logger.trace("Accessed getStudents method in StudentService");

        return studentRepository.findAll();
    }

    public ResponseEntity<StudentDto> findStudentById(Long studentId) {
        StudentDto studentById = studentRepository.findById(studentId).orElse(null);

        if (studentById != null) {
            return ResponseEntity.ok(studentById);
        } else {
//            return ResponseEntity.notFound().build();
            throw new IllegalStateException("No student registered under student id " + studentId + "!");
        }

    }

    public void addNewStudent(StudentDto student) {
        Optional<StudentDto> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email already exists!");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);

        if (!exists) {
            throw new IllegalStateException("Student with id " + studentId + " does not exists");
        }

        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        StudentDto student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException(
                "Student with id " + studentId + " does not exists!"
        ));

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<StudentDto> studentOptional = studentRepository.findStudentByEmail(email);

            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email already taken!");
            }

            student.setEmail(email);
        }
    }
}
