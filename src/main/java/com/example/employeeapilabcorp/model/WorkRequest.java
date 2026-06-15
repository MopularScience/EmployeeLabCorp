package com.example.employeeapilabcorp.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class WorkRequest {

    @Min(value = 0, message = "daysWorked must be >= 0")
    @Max(value = 260, message = "daysWorked must be <= 260")
    private int daysWorked;

    public WorkRequest() {}

    public WorkRequest(int daysWorked) {
        this.daysWorked = daysWorked;
    }

    public int getDaysWorked() {
        return daysWorked;
    }
}
