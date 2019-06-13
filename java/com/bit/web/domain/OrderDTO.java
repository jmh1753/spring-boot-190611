package com.bit.web.domain;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
/**
 * OrderDTO
 */
@Data @Component @Lazy
public class OrderDTO {
    private String orderId, customerId, employeeId, orderDate, shipperId;
   
}