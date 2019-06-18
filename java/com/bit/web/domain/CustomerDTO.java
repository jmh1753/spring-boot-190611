package com.bit.web.domain;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
/**
 * Customer
 */
@Data @Component @Lazy//겟터셋터 만들어줌
public class CustomerDTO {
    private String customerId, 
                    customerName, 
                    password,
                    ssn, 
                    phone, 
                    city, 
                    address, 
                    postalcode, 
                    photo;


    
}