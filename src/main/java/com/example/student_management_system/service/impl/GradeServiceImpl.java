package com.example.student_management_system.service.impl;

import com.example.student_management_system.entity.Grade;
import com.example.student_management_system.repository.GradeRepository;
import com.example.student_management_system.service.GradeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    private GradeRepository gradeRepository;

    public GradeServiceImpl(GradeRepository gradeRepository) {
        super();
        this.gradeRepository = gradeRepository;
    }

    public List<Grade> getAllStudentGradesById(Long id){
        return gradeRepository.getAllStudentGradesById(id);
    }

    @Override
    public Grade getGradeById(Long id) {
        return null;
    }

    @Override
    public Grade saveGrade(Grade grade) {
        return gradeRepository.save(grade);
    }
}
