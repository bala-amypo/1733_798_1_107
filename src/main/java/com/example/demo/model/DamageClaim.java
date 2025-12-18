package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class DamageClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Parcel parcel;

    private String claimDescription;

    private LocalDateTime filedAt;

    private String status = "PENDING";

    private Double score;

    @ManyToMany
    private List<ClaimRule> appliedRules;

    @PrePersist
    public void onCreate() {
        this.filedAt = LocalDateTime.now();
    }

    // Getter & Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter & Setter for parcel
    public Parcel getParcel() {
        return parcel;
    }

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }

    // Getter & Setter for claimDescription
    public String getClaimDescription() {
        return claimDescription;
    }

    public void setClaimDescription(String claimDescription) {
        this.claimDescription = claimDescription;
    }

    // Getter & Setter for filedAt
    public LocalDateTime getFiledAt() {
        return filedAt;
    }

    public void setFiledAt(LocalDateTime filedAt) {
        this.filedAt = filedAt;
    }

    // Getter & Setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getter & Setter for score
    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    // Getter & Setter for appliedRules
    public List<ClaimRule> getAppliedRules() {
        return appliedRules;
    }

    public void setAppliedRules(List<ClaimRule> appliedRules) {
        this.appliedRules = appliedRules;
    }
}
