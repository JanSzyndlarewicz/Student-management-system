package com.example.student_management_system.service;

import com.example.student_management_system.entity.Grade;

import java.util.List;

public interface GradeService {

    List<Grade> getAllStudentGradesById(Long id);
    Grade getGradeById(Long id);
    Grade saveGrade(Grade grade);

}
