package com.sandeepa.crudapp.services;

import com.sandeepa.crudapp.dtos.StudentDto;
import com.sandeepa.crudapp.entities.StudentEntity;
import com.sandeepa.crudapp.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<StudentEntity> getStudents() {

        logger.trace("Accessed getStudents method in StudentService");

        return studentRepository.findAll();
    }

    public List<StudentDto> getStudentDetails() {

        List<StudentEntity> studentEntities = studentRepository.findAll();
        List<StudentDto> studentDetails = new ArrayList<>();

        for (StudentEntity studentEntity : studentEntities) {
            StudentDto dto = new StudentDto();
            dto.setName(studentEntity.getName());
            dto.setEmail(studentEntity.getEmail());
            dto.setDob(studentEntity.getDob());
            dto.setAge(studentEntity.getAge());
            studentDetails.add(dto);
        }

        return studentDetails;

    }

    public StudentDto findStudentById(Long studentId) {

        StudentEntity studentEntity = studentRepository.findById(studentId).orElse(null);

        StudentDto studentDto = new StudentDto();
        studentDto.setName(studentEntity.getName());
        studentDto.setAge(studentEntity.getAge());
        studentDto.setEmail(studentEntity.getEmail());
        studentDto.setDob(studentEntity.getDob());
        studentDto.setSchoolName(studentEntity.getSchool().getName());
        studentDto.setClassName(studentEntity.getAClass().getName());

        return studentDto;
    }

    public void addNewStudent(StudentEntity student) {
        Optional<StudentEntity> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

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
        StudentEntity student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException(
                "Student with id " + studentId + " does not exists!"
        ));

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<StudentEntity> studentOptional = studentRepository.findStudentByEmail(email);

            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email already taken!");
            }

            student.setEmail(email);
        }
    }
}
