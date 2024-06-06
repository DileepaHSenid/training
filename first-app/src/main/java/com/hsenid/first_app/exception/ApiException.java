package com.hsenid.first_app.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/**
 * ApiException is a custom exception class used to encapsulate error details
 * that will be returned to the client in case of an API request failure.
 */
@Data
public class ApiException {

    /**
     * The error message describing the exception.
     */
    private final String message;

    /**
     * The underlying cause of the exception.
     */
    private final Throwable throwable;

    /**
     * The HTTP status code to be returned in the response.
     */
    private final HttpStatus httpStatus;

    /**
     * The timestamp when the exception occurred.
     */
    private final ZonedDateTime timestamp;

    /**
     * Constructs an ApiException instance with the given details.
     *
     * @param message   The error message describing the exception.
     * @param throwable The underlying cause of the exception.
     * @param httpStatus The HTTP status code to be returned in the response.
     * @param timestamp The timestamp when the exception occurred.
     */
    public ApiException(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime timestamp) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }
}
