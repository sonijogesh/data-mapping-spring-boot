package com.jogeshsoni.datamapping.DataMapping.services;

import com.jogeshsoni.datamapping.DataMapping.entities.EmployeeEntity;
import com.jogeshsoni.datamapping.DataMapping.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity createNewEmployee(EmployeeEntity employeeEntity){
        return employeeRepository.save(employeeEntity);
    }

    public EmployeeEntity getEmployeeById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    public boolean deleteEmployeeById(Long id) {
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
