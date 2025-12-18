package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(
    name = "user",
    uniqueConstraints = @UniqueConstraint(columnNames = "email")
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password; 

    @Column(nullable = false)
    private String role;

    
    @PrePersist
    public void setDefaultRole() {
        if (this.role == null) {
            this.role = "AGENT";
        }
    }

    // Getters and Setters
}
