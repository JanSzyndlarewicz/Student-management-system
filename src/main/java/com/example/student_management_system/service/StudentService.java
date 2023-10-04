package com.example.student_management_system.service;

import com.example.student_management_system.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StudentService {

    Page<Student> getAllStudents(@RequestParam(defaultValue = "0") Integer pageNo,
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 @RequestParam(defaultValue = "id") String sortBy,
                                 @RequestParam(defaultValue = "ASC") String sortDirection);

    List<Student> getAllStudents();

    Student saveStudent(Student student);
    Student getStudentById(Long id);
    Student updateStudent(Student student);
    List<Integer> getStudentGrades(Long id);

    void deleteStudentById(Long id);
}
