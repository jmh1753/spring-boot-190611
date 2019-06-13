package com.bit.web.domain;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
/**
 * ProductDTO
 */
@Data @Component @Lazy
public class ProductDTO {
    private String productId,
    productName,
    supplierId,
    categoryId,
    unit,
    price;
   
    
}