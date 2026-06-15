package com.example.employeeapilabcorp.model;

public class Manager extends SalariedEmployee{
    public static final double VACATION_DAYS_PER_YEAR = 30.0;

    public Manager(int id, String name) {
        super(id, name);
    }

    @Override
    public double getVacationDaysPerYear() {
        return VACATION_DAYS_PER_YEAR;
    }

    @Override
    public String getEmployeeType() {
        return "MANAGER";
    }
}
