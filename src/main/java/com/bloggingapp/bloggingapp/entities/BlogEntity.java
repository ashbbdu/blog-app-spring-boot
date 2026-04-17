package com.bloggingapp.bloggingapp.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.NotFound;

import java.time.LocalDateTime;

@Entity()
@Table(name = "blogs")
@Data
public class BlogEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String password; // will be adding custom validator => done
    private String role;
    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
