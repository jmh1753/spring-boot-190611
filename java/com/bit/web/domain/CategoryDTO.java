package com.bit.web.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * CategoryDTO
 */
@Data @Component @Lazy    //컴포넌트는 타입을줌 
public class CategoryDTO {
    private String  categoryId,
                    categoryName,
                    description;
    
}