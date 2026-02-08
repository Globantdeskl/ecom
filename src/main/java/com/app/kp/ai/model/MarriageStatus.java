package com.app.kp.ai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "marriage_status")
public class MarriageStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "husband_id", nullable = false)
    private Person husband;

    private boolean stressed;
    private boolean broken;
    private boolean recoverable;

    // ✅ Mandatory no-arg constructor
    public MarriageStatus() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getHusband() {
        return husband;
    }

    public void setHusband(Person husband) {
        this.husband = husband;
    }

    public boolean isStressed() {
        return stressed;
    }

    public void setStressed(boolean stressed) {
        this.stressed = stressed;
    }

    public boolean isBroken() {
        return broken;
    }

    public void setBroken(boolean broken) {
        this.broken = broken;
    }

    public boolean isRecoverable() {
        return recoverable;
    }

    public void setRecoverable(boolean recoverable) {
        this.recoverable = recoverable;
    }
}
