package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "evidence")
public class Evidence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many evidence → one claim
    @ManyToOne
    private DamageClaim claim;

    private String evidenceType;

    private String fileUrl;

    private LocalDateTime uploadedAt;

    // ✅ No-arg constructor (REQUIRED by tests)
    public Evidence() {
        this.uploadedAt = LocalDateTime.now(); // ⭐ IMPORTANT
    }

    @PrePersist
    public void onUpload() {
        if (this.uploadedAt == null) {
            this.uploadedAt = LocalDateTime.now();
        }
    }

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
    }

    public DamageClaim getClaim() {
        return claim;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClaim(DamageClaim claim) {
        this.claim = claim;
    }

    public String getEvidenceType() {
        return evidenceType;
    }

    public void setEvidenceType(String evidenceType) {
        this.evidenceType = evidenceType;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }
}
