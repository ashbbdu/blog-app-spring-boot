package com.bloggingapp.bloggingapp.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class RoleValidator implements ConstraintValidator<RoleValidation, String> {


    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext constraintValidatorContext) {
        List<String> roles = List.of("User" , "Author");
        if(roles.contains(inputRole)) {
            return true;
        }
        return false;

//        or

//        return roles.contains(inputRole);
    }
}
