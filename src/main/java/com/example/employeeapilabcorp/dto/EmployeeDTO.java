package com.example.employeeapilabcorp.dto;

import com.example.employeeapilabcorp.model.Employee;

public class EmployeeDTO {

    private final int id;
    private final String name;
    private final String employeeType;
    private final double vacationDaysAccumulated;
    private final int daysWorkedThisYear;
    private final double vacationDaysPerYear;

    public EmployeeDTO(Employee employee) {
        this.id                      = employee.getId();
        this.name                    = employee.getName();
        this.employeeType            = employee.getEmployeeType();
        this.vacationDaysAccumulated = employee.getVacationDaysAccumulated();
        this.daysWorkedThisYear      = employee.getDaysWorkedThisYear();
        this.vacationDaysPerYear     = employee.getVacationDaysPerYear();
    }

    public int getId()                          { return id; }
    public String getName()                     { return name; }
    public String getEmployeeType()             { return employeeType; }
    public double getVacationDaysAccumulated()  { return vacationDaysAccumulated; }
    public int getDaysWorkedThisYear()          { return daysWorkedThisYear; }
    public double getVacationDaysPerYear()      { return vacationDaysPerYear; }
}
