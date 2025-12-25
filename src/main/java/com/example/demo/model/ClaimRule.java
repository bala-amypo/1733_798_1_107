package com.example.demo.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "claim_rules")
public class ClaimRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;

    private String conditionExpression;

    private Double weight;

    @ManyToMany(mappedBy = "appliedRules")
    private Set<DamageClaim> claims;

    // ✅ No-arg constructor (REQUIRED by tests)
    public ClaimRule() {
        this.claims = new HashSet<>();   // ⭐ IMPORTANT
    }

    // ✅ Parameterized constructor (REQUIRED)
    public ClaimRule(String ruleName, String conditionExpression, Double weight) {
        this.ruleName = ruleName;
        this.conditionExpression = conditionExpression;
        this.weight = weight;
        this.claims = new HashSet<>();   // ⭐ IMPORTANT
    }

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public String getConditionExpression() {
        return conditionExpression;
    }

    public Double getWeight() {
        return weight;
    }

    public Set<DamageClaim> getClaims() {
        return claims;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public void setConditionExpression(String conditionExpression) {
        this.conditionExpression = conditionExpression;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
