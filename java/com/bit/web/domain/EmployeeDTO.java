package com.bit.web.domain;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
/**
 * EmployeeDTO
 */
@Data @Component @Lazy
public class EmployeeDTO {

    private String employeeId, manager, name, birthDate, photo, notes;

 
}