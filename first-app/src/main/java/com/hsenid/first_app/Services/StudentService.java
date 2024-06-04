package com.hsenid.first_app.services;

import com.hsenid.first_app.dto.mapper.StudentMapper;
import com.hsenid.first_app.dto.request.StudentRequest;
import com.hsenid.first_app.dto.response.StudentResponse;
import com.hsenid.first_app.exception.ApiRequestException;
import com.hsenid.first_app.model.Student;
import com.hsenid.first_app.repositories.StudentRepo;
import com.hsenid.first_app.validations.DoubleValidator;
import com.hsenid.first_app.validations.StringValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Spring annotation to indicate that this class is a service component
@Service
public class StudentService {

    // Autowire the StudentRepo to inject its dependency
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ValidationService validationService;

    /**
     * Method to retrieve all students
     * @return a list of all students
     */
    public List<StudentResponse> getAllStudents() {
        List<Student> students = studentRepo.findAll();
        List<StudentResponse> studentResponses = new ArrayList<>();
        for (Student student : students) {
            studentResponses.add(StudentMapper.studentToDTO(student));
        }
        if (studentResponses.isEmpty()) {
            throw new ApiRequestException("There are no students in the database");
        }
        return studentResponses;
    }

    /**
     * Retrieves a student by their ID and converts the student entity to a DTO.
     *
     * @param id The ID of the student to retrieve.
     * @return The StudentResponse DTO containing student details.
     * @throws ApiRequestException if the student with the given ID is not found.
     */
    public StudentResponse getStudentById(String id) {
        // Retrieve the student from the repository by their ID
        Optional<Student> studentOptional = studentRepo.findById(id);

        // Check if the student is present in the optional
        if (studentOptional.isEmpty()) {
            // Throw an exception if the student is not found
            throw new ApiRequestException("Student with ID " + id + " not found");
        }

        // Convert the student entity to a StudentResponse DTO and return it
        return StudentMapper.studentToDTO(studentOptional.get());
    }

    /**
     * Method to add a new student
     * @param studentRequest The request object containing student details.
     */
    public void addStudent(StudentRequest studentRequest) {
        boolean isValidRequest = validationService.isValidStudentRequest(studentRequest.average(), studentRequest.name());
        if (isValidRequest) {
            studentRepo.save(StudentMapper.dtoToStudent(studentRequest));
        } else {
            throw new ApiRequestException("Entered Data type is not valid");
        }
    }

    /*
     * Method to remove a student by their ID
     * @param id the ID of the student to be removed
     */
    public void removeStudent(String id) {
        // Retrieve the student from the repository by their ID
        Optional<Student> studentOptional = studentRepo.findById(id);

        // Check if the student is present in the optional
        if (studentOptional.isEmpty()) {
            // Throw an exception if the student is not found
            throw new ApiRequestException("Student with ID " + id + " not found to be removed!");
        }

        // Remove the student by their ID
        studentRepo.deleteById(id);
    }
}
