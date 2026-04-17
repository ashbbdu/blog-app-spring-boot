package com.bloggingapp.bloggingapp.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordValidation { // this will be used in the DTO
    String message() default "Invalid user role";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
