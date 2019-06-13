package com.bit.web.service;

import java.util.List;

import com.bit.web.domain.EmployeeDTO;

import org.springframework.stereotype.Component;

/**
 * EmployeeService
 */
@Component
public interface EmployeeService {
    public void addEmployee(EmployeeDTO employee);    
    public List<EmployeeDTO> findEmployees();
    public List<EmployeeDTO> findEmployeesByOption(EmployeeDTO option);
    public EmployeeDTO findEmployeeByemployeeId(String employeeId);
    public void updateEmployee(EmployeeDTO employee);
    public void deleteEmployee(EmployeeDTO employee);
    
}