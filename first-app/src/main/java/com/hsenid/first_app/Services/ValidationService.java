package com.hsenid.first_app.services;

import com.hsenid.first_app.validations.DoubleValidator;
import com.hsenid.first_app.validations.StringValidator;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public boolean isValidStudentRequest(double average, String name) {
        return DoubleValidator.isValid(average) && StringValidator.isValid(name);
    }
}