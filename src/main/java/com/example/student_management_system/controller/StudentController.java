package com.example.student_management_system.controller;

import com.example.student_management_system.entity.Student;
import com.example.student_management_system.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;
    private String previousPage = null;

    public StudentController(StudentService studentService){
        super();
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        return findPaginated(1, "firstName", "asc", model);
    }

    @GetMapping("/students")
    public String listStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }


    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        Student student= new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        if(previousPage != null){
            String url = "redirect:" + previousPage;
            previousPage = null;
            return url;
        }
        else{
            return "redirect:/";
        }

    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
    @ModelAttribute("student") Student student, Model model){
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        studentService.updateStudent(existingStudent);
        if(previousPage != null){
            String url = "redirect:" + previousPage;
            previousPage = null;
            return url;
        }
        else{
            return "redirect:/";
        }
    }

    @GetMapping("students/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        if(previousPage != null){
            String url = "redirect:" + previousPage;
            previousPage = null;
            return url;
        }
        else{
            return "redirect:/";
        }
    }

    @GetMapping("students/{id}/grades")
    public String getGrades(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "grades";
    }


    @GetMapping("/students/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model){
        int pageSize = 5;

        Page<Student> page = studentService.getAllStudents(pageNo, pageSize, sortField, sortDir);
        List<Student> listStudents = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("students", listStudents);
        previousPage = "/students/page/" + pageNo + "?sortField=" + sortField + "&sortDir=" + sortDir;

        return "students";
    }
}
