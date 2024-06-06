package com.hsenid.first_app.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

/**
 * Record class representing a request to create or update a Student.
 *
 * @param id the unique identifier of the student.
 * @param name the name of the student.
 * @param dob the date of birth of the student.
 * @param average the average grade of the student.
 */
public record StudentRequest(

        // @NotBlank user to check both null and empty
        // @Email use to check the email validation
        @NotNull(message = "User Id Should not be null!")
        @NotEmpty(message = "User Id Should not be Empty!")
        String id,

        @NotNull(message = "User Name Should not be null!")
        @NotEmpty(message = "User Date of birth Should not be Empty!")
        String name,

        LocalDate dob,

        double average
) {

}
