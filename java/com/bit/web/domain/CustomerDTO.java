package com.bit.web.domain;

import lombok.Data;

/**
 * Customer
 */
@Data //겟터셋터 만들어줌
public class CustomerDTO {
    private String customerId, 
                    customerName, 
                    password, 
                    phone, 
                    city, 
                    address, 
                    postalcode, 
                    photo;


    
}