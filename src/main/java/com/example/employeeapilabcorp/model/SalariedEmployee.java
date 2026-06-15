package com.example.employeeapilabcorp.model;

public class SalariedEmployee extends Employee {
    public static final double VACATION_DAYS_PER_YEAR = 15.0;

    public SalariedEmployee(int id, String name) {
        super(id, name);
    }

    @Override
    public double getVacationDaysPerYear() {
        return VACATION_DAYS_PER_YEAR;
    }

    @Override
    public String getEmployeeType() {
        return "SALARIED";
    }
}
