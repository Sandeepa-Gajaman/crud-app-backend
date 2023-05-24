package com.sandeepa.crudapp.repository;

import com.sandeepa.crudapp.dto.SchoolDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<SchoolDto, Long> {
}
