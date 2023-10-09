package com.example.student_management_system.controller;

import com.example.student_management_system.entity.Grade;
import com.example.student_management_system.service.GradeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GradeController {

    private GradeService gradeService;

    public GradeController(GradeService gradeService) {
        super();
        this.gradeService = gradeService;
    }

    @GetMapping("/students/{id}/grades")
    public String getGrades(@PathVariable Long id, Model model) {
        model.addAttribute("grades", gradeService.getAllStudentGradesById(id));
        return "grades";
    }

    @GetMapping("/students/{id}/grades/{grade}")
    public String addGrade(@PathVariable Long id, @PathVariable Integer grade) {
        gradeService.saveGrade(new Grade(id, grade));
        return "redirect:/students/" + id + "/grades";
    }
}
