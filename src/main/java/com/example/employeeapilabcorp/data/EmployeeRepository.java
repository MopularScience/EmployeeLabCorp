package com.example.employeeapilabcorp.data;

import com.example.employeeapilabcorp.model.Employee;
import com.example.employeeapilabcorp.model.HourlyEmployee;
import com.example.employeeapilabcorp.model.Manager;
import com.example.employeeapilabcorp.model.SalariedEmployee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeRepository {
    private final List<Employee> employees;

    public EmployeeRepository() {
        List<Employee> seed = new ArrayList<>();

        // 10 hourly employees  (IDs 1–10)
        for (int i = 1; i <= 10; i++) {
            seed.add(new HourlyEmployee(i, "Hourly Employee " + i));
        }

        // 10 salaried employees (IDs 11–20)
        for (int i = 1; i <= 10; i++) {
            seed.add(new SalariedEmployee(i + 10, "Salaried Employee " + i));
        }

        // 10 managers           (IDs 21–30)
        for (int i = 1; i <= 10; i++) {
            seed.add(new Manager(i + 20, "Manager " + i));
        }

        this.employees = seed;
    }


    public List<Employee> findAll() {
        return Collections.unmodifiableList(employees);
    }

    //Returns all employees of a given type string
    public List<Employee> findByType(String type) {
        return employees.stream()
                .filter(e -> e.getEmployeeType().equalsIgnoreCase(type))
                .toList();
    }

    // Looks up a single employee by ID.
    public Optional<Employee> findById(int id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }
}
