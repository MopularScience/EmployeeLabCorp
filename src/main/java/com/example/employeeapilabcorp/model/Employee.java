package com.example.employeeapilabcorp.model;

public abstract class Employee {

    public static final int WORK_DAYS_PER_YEAR = 260;

    private final int id;
    private final String name;
    private double vacationDaysAccumulated;
    private int daysWorkedThisYear;

    protected Employee(int id, String name) {
        this.id = id;
        this.name = name;
        this.vacationDaysAccumulated = 0.0;
        this.daysWorkedThisYear = 0;
    }


    public abstract double getVacationDaysPerYear();

    public abstract String getEmployeeType();

    public void work(int daysWorked) {
        if (daysWorked < 0 || daysWorked > WORK_DAYS_PER_YEAR) {
            throw new IllegalArgumentException(
                    "daysWorked must be between 0 and " + WORK_DAYS_PER_YEAR
                            + ", but was " + daysWorked);
        }
        int projectedTotal = daysWorkedThisYear + daysWorked;
        if (projectedTotal > WORK_DAYS_PER_YEAR) {
            throw new IllegalArgumentException(
                    "Cannot work more than " + WORK_DAYS_PER_YEAR
                            + " days per year. Already worked " + daysWorkedThisYear
                            + " days; attempted to add " + daysWorked + " more.");
        }

        double accrualRate = getVacationDaysPerYear() / WORK_DAYS_PER_YEAR;
        vacationDaysAccumulated += daysWorked * accrualRate;
        daysWorkedThisYear = projectedTotal;
    }

    //Make sure you understand this string formatting
    public void takeVacation(double days) {
        if (days <= 0) {
            throw new IllegalArgumentException(
                    "Vacation days must be a positive value, but was " + days);
        }
        if (days > vacationDaysAccumulated) {
            throw new IllegalArgumentException(
                    "Cannot take " + days + " vacation day(s); only "
                            + String.format("%.4f", vacationDaysAccumulated) + " available.");
        }
        vacationDaysAccumulated -= days;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //Don't want to update these externally
    public double getVacationDaysAccumulated() {
        return vacationDaysAccumulated;
    }

    public int getDaysWorkedThisYear() {
        return daysWorkedThisYear;
    }
}
