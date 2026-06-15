package com.example.employeeapilabcorp.model;

public class HourlyEmployee extends Employee {
    public static final double VACATION_DAYS_PER_YEAR = 10.0;

    public HourlyEmployee(int id, String name) {
        super(id, name);
    }

    @Override
    public double getVacationDaysPerYear() {
        return VACATION_DAYS_PER_YEAR;
    }

    @Override
    public String getEmployeeType() {
        return "HOURLY";
    }

}
