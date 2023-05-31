package com.sandeepa.crudapp.controller;

import com.sandeepa.crudapp.dto.StudentDto;
import com.sandeepa.crudapp.entities.StudentEntity;
import com.sandeepa.crudapp.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentEntity> getStudents() {

        logger.trace("This is a TRACE Log"); //By default, it is not shown in the console. Check the application properties file.
        logger.info("This is a INFO Log");
        logger.debug("This is a DEBUG Log");

        logger.trace("Accessed getStudents method in StudentController");

        return studentService.getStudents();
    }

    //New method for student details
    @GetMapping(path = "/details")
    public List<StudentDto> getStudentDetails() {

        return studentService.getStudentDetails();
    }

    @GetMapping(path = "{studentId}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable("studentId") Long studentId) {

        StudentEntity studentById = studentService.findStudentById(studentId);

        if(studentById != null){
            return ResponseEntity.ok(studentById);
        } else {
//            return ResponseEntity.notFound().build();
            throw new IllegalStateException("No student registered under student id " + studentId + "!");
        }
    }

    @PostMapping
    public void registerNewStudent(@RequestBody StudentEntity student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);}
}
