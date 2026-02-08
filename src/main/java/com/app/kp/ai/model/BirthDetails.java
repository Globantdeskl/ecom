package com.app.kp.ai.model;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class BirthDetails {
    private LocalDate date;
    private LocalTime time;
    private double latitude;
    private double longitude;
    private double timezone;
}

