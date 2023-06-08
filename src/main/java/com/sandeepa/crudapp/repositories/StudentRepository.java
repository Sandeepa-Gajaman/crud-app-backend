package com.sandeepa.crudapp.repositories;

import com.sandeepa.crudapp.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

    @Query("SELECT s FROM StudentEntity s WHERE s.email = ?1")
    Optional<StudentEntity> findStudentByEmail(String email);

    @Query("SELECT s FROM StudentEntity s WHERE s.name LIKE %:keyword%")
    List<StudentEntity> searchStudentByKeyword(String keyword);
}
