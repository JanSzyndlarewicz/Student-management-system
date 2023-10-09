package com.example.student_management_system.repository;

import com.example.student_management_system.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {

    @Query(value = "SELECT * FROM grades where grades.student_id = :id",
            nativeQuery = true)
    List<Grade> getAllStudentGradesById(@Param("id") Long id);
}

