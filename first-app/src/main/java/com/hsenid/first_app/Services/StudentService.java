package com.hsenid.first_app.Services;

import com.hsenid.first_app.Model.Student;
import com.hsenid.first_app.Repositories.StudentRepo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Spring annotation to indicate that this class is a service component
@Service
public class StudentService {

    // Autowire the StudentRepo to inject its dependency
    @Autowired
    private StudentRepo studentRepo;

    /**
     * Method to retrieve all students
     * @return a list of all students
     */
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    /**
     * Method to retrieve a student by their ID
     * @param id the ID of the student to retrieve
     * @return the student with the given ID, or null if no such student exists
     */
    public Student getStudentById(String id) {
        return studentRepo.findById(id).orElse(null);
    }

    /**
     * Method to add a new student
     * @param student the student to be added
     */
    public void addStudent(Student student) {
        studentRepo.save(student);
    }

    /**
     * Method to remove a student by their ID
     * @param id the ID of the student to be removed
     */
    public void removeStudent(String id) {
        studentRepo.deleteById(id);
    }
}
