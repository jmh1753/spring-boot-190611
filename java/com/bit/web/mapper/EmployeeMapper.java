package com.bit.web.mapper;

import java.util.List;

import com.bit.web.domain.EmployeeDTO;

import org.springframework.stereotype.Repository;

/**
 * EmployeeMapper
 */
@Repository
public interface EmployeeMapper {
    public void insertEmployee(EmployeeDTO employee);    
    public List<EmployeeDTO> selectEmployees();
    public List<EmployeeDTO> selectEmployeesByOption(EmployeeDTO option);
    public EmployeeDTO selectEmployeeByemployeeId(String employeeId);
    public void updateEmployee(EmployeeDTO employee);
    public void deleteEmployee(EmployeeDTO employee);
    
}