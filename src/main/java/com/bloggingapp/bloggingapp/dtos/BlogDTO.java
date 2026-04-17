package com.bloggingapp.bloggingapp.dtos;

import com.bloggingapp.bloggingapp.annotations.PasswordValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class BlogDTO {
    private Long id;

    @NotBlank
    @Size(min = 3 , max = 10, message = "First name should be more than 3 character and should be lesser or equal to 10 !")

    private String first_name;

    @NotBlank
    @Size(min = 3 , max = 10, message = "Last name should be more than 3 character and should be lesser or equal to 10 !")

    private String last_name;
    @Email(message = "Invalid Email !")
    private String email;

    @NotBlank(message = "Password is required !")

    private String password;

    @NotBlank(message = "Role is required !")
    @PasswordValidation()
    private String role;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
