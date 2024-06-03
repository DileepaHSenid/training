package com.hsenid.first_app.Controllers;

import com.hsenid.first_app.Model.Student;
import com.hsenid.first_app.Services.StudentService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Lombok annotations to generate getter and setter methods
@Getter
@Setter
// Annotation to mark this class as a RESTful web service controller
@RestController
// Base URL for all endpoints in this controller
@RequestMapping("/students")
public class StudentController {

    // Service layer dependency for handling business logic
    private final StudentService studentService;

    // Constructor with dependency injection
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Endpoint to retrieve the list of all students
    @GetMapping
    public List<Student> studentList() {
        return studentService.getAllStudents();
    }

    // Endpoint to retrieve a student by their ID
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id) {
        return studentService.getStudentById(id);
    }

    // New endpoint to create a student
    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    // Endpoint to remove a student by their ID
    @DeleteMapping("/removeStudent/{id}")
    public void removeStudent(@PathVariable String id) {
        studentService.removeStudent(id);
    }
}
