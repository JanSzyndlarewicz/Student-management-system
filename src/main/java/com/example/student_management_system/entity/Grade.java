package com.example.student_management_system.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "grades")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id", nullable = false)
    private Long student_id;

    @Column(name = "grade", nullable = false)
    private Integer grade;

    @Column(name = "description")
    private String description;

    public Grade() {
    }

    public Grade(Long student_id, Integer grade) {
        super();
        this.student_id = student_id;
        this.grade = grade;
        this.description = "";
    }

    public Grade(Long student_id, Integer grade, String description) {
        super();
        this.student_id = student_id;
        this.grade = grade;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

