package com.sandeepa.crudapp.repository;

import com.sandeepa.crudapp.dto.StudentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentDTO,Long> {

//    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<StudentDTO> findStudentByEmail(String email);
}
