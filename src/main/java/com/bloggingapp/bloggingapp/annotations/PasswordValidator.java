package com.bloggingapp.bloggingapp.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class PasswordValidator implements ConstraintValidator<PasswordValidation , String> {
    @Override
    public boolean isValid(String inputPassword, ConstraintValidatorContext constraintValidatorContext) {
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*]).{8,16}$";
        return inputPassword != null && inputPassword.matches(regex);
    }
}
