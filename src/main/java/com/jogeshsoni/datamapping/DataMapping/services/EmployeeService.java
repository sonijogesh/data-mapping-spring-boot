package com.jogeshsoni.datamapping.DataMapping.services;

import com.jogeshsoni.datamapping.DataMapping.entities.DepartmentEntity;
import com.jogeshsoni.datamapping.DataMapping.entities.EmployeeEntity;
import com.jogeshsoni.datamapping.DataMapping.repositories.DepartmentRepository;
import com.jogeshsoni.datamapping.DataMapping.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public EmployeeEntity createNewEmployee(EmployeeEntity employeeEntity){
        return employeeRepository.save(employeeEntity);
    }

    public EmployeeEntity getEmployeeById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    public boolean deleteEmployeeById(Long id) {
        if(employeeRepository.existsById(id)){
            EmployeeEntity employee = getEmployeeById(id);

            for (DepartmentEntity department : employee.getFreelanceDepartments()){
                department.getFreelancers().remove(employee);
            }

            departmentRepository.saveAll(employee.getFreelanceDepartments());

            employeeRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
