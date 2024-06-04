package com.hsenid.first_app.exception;

import lombok.Data;

/**
 * Custom exception class for API request-related exceptions.
 * Extends RuntimeException to indicate that it is an unchecked exception.
 */
@Data
public class ApiRequestException extends RuntimeException {

    /**
     * Constructs an ApiRequestException with the specified detail message.
     *
     * @param message The detail message (which is saved for later retrieval by the getMessage() method).
     */
    public ApiRequestException(String message) {
        super(message);
    }

    /**
     * Constructs an ApiRequestException with the specified detail message and cause.
     *
     * @param message The detail message (which is saved for later retrieval by the getMessage() method).
     * @param cause   The cause (which is saved for later retrieval by the getCause() method).
     */
    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
