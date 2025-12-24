package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "users",
    uniqueConstraints = @UniqueConstraint(columnNames = "email")
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    // ✅ DEFAULT ROLE FIX
    @Column(nullable = false)
    private String role = "USER";

    // ✅ No-arg constructor (REQUIRED)
    public User() {
        // role already set to USER
    }

    // ✅ Parameterized constructor (REQUIRED by tests)
    public User(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;

        // ✅ SAFETY: if role is null → USER
        this.role = (role == null || role.isEmpty()) ? "USER" : role;
    }

    // ✅ Auto-fix if role not set before persist
    @PrePersist
    protected void assignDefaultRole() {
        if (this.role == null || this.role.isEmpty()) {
            this.role = "USER";
        }
    }

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
}
