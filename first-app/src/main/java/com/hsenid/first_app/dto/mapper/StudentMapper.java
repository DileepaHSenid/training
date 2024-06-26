package com.hsenid.first_app.dto.mapper;

import com.hsenid.first_app.dto.request.StudentRequest;
import com.hsenid.first_app.dto.response.StudentResponse;
import com.hsenid.first_app.model.Student;

/**
 * Mapper class to convert Student model to StudentResponse DTO.
 */
public class StudentMapper {

    /**
     * Converts a Student object to a StudentResponse DTO.
     *
     * @param student the Student object to be converted.
     * @return the converted StudentResponse object.
     */
    public static StudentResponse studentToDTO(Student student) {
        // Create a new instance of StudentResponse
        // Set the ID and the name of the StudentResponse from the Student object
        return new StudentResponse(student.getId(), student.getName());

    }

    /**
     * Converts a StudentResponse DTO to a Student object.
     *
     * @param studentRequest the StudentResponse DTO to be converted.
     * @return the converted Student object.
     */
    public static Student dtoToStudent(StudentRequest studentRequest) {
        return new Student(studentRequest.id(), studentRequest.name(), studentRequest.dob(), studentRequest.average());
    }
     
}
