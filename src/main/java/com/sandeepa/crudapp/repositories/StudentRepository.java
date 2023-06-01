package com.sandeepa.crudapp.repositories;

import com.sandeepa.crudapp.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

//    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<StudentEntity> findStudentByEmail(String email);
}
