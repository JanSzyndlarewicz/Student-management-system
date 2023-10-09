package com.example.student_management_system.entity;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @ElementCollection
    @Column(name = "grades")
    public List<Integer> grades;

    public Student() {

    }

    public Student(String firstName, String lastName, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.grades = new ArrayList<>();
    }

   public Student(String firstName, String lastName, String email, List<Integer> grades) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.grades = grades;
    }

    public Student(String firstName, String lastName, String email, Integer grade) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.grades = List.of(grade);
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }
}
