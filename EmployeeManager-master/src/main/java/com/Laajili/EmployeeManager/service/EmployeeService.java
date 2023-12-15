package com.Laajili.EmployeeManager.service;

import com.Laajili.EmployeeManager.Employee.Employee;
import com.Laajili.EmployeeManager.exception.UserNotFoundException;
import com.Laajili.EmployeeManager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo){

        this.employeeRepo=employeeRepo;
    }
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }
    public List<Employee> findAllEmployee() {
     return employeeRepo.findAll();
    }
    public Employee updateEployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id) throws UserNotFoundException {
        return employeeRepo.findEmployeeById(id).orElseThrow(()->new UserNotFoundException("User By ID "+id+" was not found"));
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }
}
