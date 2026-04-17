package com.bloggingapp.bloggingapp.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordValidation {
    String message() default "Password must be 8-16 characters long, include uppercase, lowercase, and special character and one digit.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
