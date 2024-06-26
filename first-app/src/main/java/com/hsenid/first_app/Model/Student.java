package com.hsenid.first_app.model;

// Import the necessary classes and annotations
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

// Lombok's annotation to mark this class as a MongoDB document
@Document
@Data
// Lombok's annotation to generate a no-argument constructor
@NoArgsConstructor
// Lombok's annotation to generate an all-argument constructor
@AllArgsConstructor
public class Student {

    // Annotation to specify the field used as the ID in the MongoDB document
    @Id
    private String id;

    // Field to store the student's name
    private String name;

    // Field to store the student's date of birth
    private LocalDate dateOfBirth;

    // Field to store the student's average score
    private double average;

}
