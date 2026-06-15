package com.example.employeeapilabcorp.model;

import jakarta.validation.constraints.Positive;

public class VacationRequest {

    @Positive(message = "vacationDays must be a positive value")
    private double vacationDays;

    public VacationRequest() {}

    public VacationRequest(double vacationDays) {
        this.vacationDays = vacationDays;
    }

    public double getVacationDays() {
        return vacationDays;
    }
}
