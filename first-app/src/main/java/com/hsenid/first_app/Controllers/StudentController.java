package com.hsenid.first_app.controllers;

import com.hsenid.first_app.dto.request.StudentRequest;
import com.hsenid.first_app.dto.response.StudentResponse;
import com.hsenid.first_app.model.Student;
import com.hsenid.first_app.services.StudentService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Annotation to mark this class as a RESTFUL web service controller
@RestController
// Adding the logger slf4j
@Slf4j
// Base URL for all endpoints in this controller
@RequestMapping("/students")
public class StudentController {


    // Service layer dependency for handling business logic
    @Autowired
    private StudentService studentService;

    // Endpoint to retrieve the list of all students
    @GetMapping
    public ResponseEntity <List<StudentResponse>> studentList() {
        log.trace("Students are listed!");
        return ResponseEntity.ok( studentService.getAllStudents());
    }

    // Endpoint to retrieve a student by their ID
    @GetMapping("/{id}")
    public ResponseEntity <StudentResponse> getStudent(@PathVariable String id) {
        log.trace("Student corresponding to {} is found!", id);
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    // New endpoint to create a student
    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody @Valid StudentRequest studentRequest) {
        studentService.addStudent(studentRequest);
        log.trace("Student added successfully!");
        return ResponseEntity.ok("Student added successfully!");
    }

    // Endpoint to remove a student by their ID
    @DeleteMapping("/removeStudent/{id}")
    public ResponseEntity<String> removeStudent(@PathVariable String id) {
        studentService.removeStudent(id);
        log.trace("Student removed successfully!");
        return ResponseEntity.ok("Student removed successfully!");
    }
}
