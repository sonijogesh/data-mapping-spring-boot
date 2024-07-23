package com.jogeshsoni.datamapping.DataMapping.controllers;

import com.jogeshsoni.datamapping.DataMapping.entities.EmployeeEntity;
import com.jogeshsoni.datamapping.DataMapping.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name = "employeeId") Long id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity employeeEntity){
        return employeeService.createNewEmployee(employeeEntity);
    }

    @DeleteMapping(path = "/{employeeId}")
    public boolean deleteEmployee(@PathVariable(name = "employeeId") Long id){
        return employeeService.deleteEmployeeById(id);
    }
}
