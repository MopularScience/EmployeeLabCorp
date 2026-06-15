package com.example.employeeapilabcorp.service;

import com.example.employeeapilabcorp.data.EmployeeRepository;
import com.example.employeeapilabcorp.dto.EmployeeDTO;
import com.example.employeeapilabcorp.model.Employee;
import org.springframework.stereotype.Service;
import com.example.employeeapilabcorp.exception.EmployeeNotFoundException;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<EmployeeDTO> getAllEmployees() {
        return repository.findAll().stream()
                .map(EmployeeDTO::new)
                .toList();
    }

    /**
     * Returns all employees of a given type.
     *
     * @param type one of HOURLY | SALARIED | MANAGER (case-insensitive)
     */
    public List<EmployeeDTO> getEmployeesByType(String type) {
        return repository.findByType(type).stream()
                .map(EmployeeDTO::new)
                .toList();
    }

    public EmployeeDTO getEmployeeById(int id) {
        Employee employee = findOrThrow(id);
        return new EmployeeDTO(employee);
    }

    public EmployeeDTO recordWork(int id, int daysWorked) {
        Employee employee = findOrThrow(id);
        employee.work(daysWorked);
        return new EmployeeDTO(employee);
    }

    public EmployeeDTO recordVacation(int id, double vacationDays) {
        Employee employee = findOrThrow(id);
        employee.takeVacation(vacationDays);
        return new EmployeeDTO(employee);
    }


    private Employee findOrThrow(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

}

