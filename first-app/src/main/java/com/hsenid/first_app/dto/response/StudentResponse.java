package com.hsenid.first_app.dto.response;

/**
 * Record class representing a response containing student details.
 *
 * @param id the unique identifier of the student.
 * @param name the name of the student.
 */
public record StudentResponse (
        String id,
        String name
) {}
