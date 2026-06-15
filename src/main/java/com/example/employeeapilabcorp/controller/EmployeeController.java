package com.example.employeeapilabcorp.controller;
import com.example.employeeapilabcorp.dto.EmployeeDTO;
import com.example.employeeapilabcorp.model.VacationRequest;
import com.example.employeeapilabcorp.model.WorkRequest;
import com.example.employeeapilabcorp.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getEmployees(
            @RequestParam(required = false) String type) {
        List<EmployeeDTO> result;

        if (type == null || type.isBlank()) {
            result = employeeService.getAllEmployees();
        } else {
            result = employeeService.getEmployeesByType(type);
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable int id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PostMapping("/{id}/work")
    public ResponseEntity<EmployeeDTO> recordWork(
            @PathVariable int id,
            @Valid @RequestBody WorkRequest request) {

        EmployeeDTO updated = employeeService.recordWork(id, request.getDaysWorked());
        return ResponseEntity.ok(updated);
    }

    @PostMapping("/{id}/vacation")
    public ResponseEntity<EmployeeDTO> recordVacation(
            @PathVariable int id,
            @Valid @RequestBody VacationRequest request) {

        EmployeeDTO updated = employeeService.recordVacation(id, request.getVacationDays());
        return ResponseEntity.ok(updated);
    }
}
