package com.bit.web.domain;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
/**
 * ShipperDTO
 */
@Data @Component @Lazy
public class ShipperDTO {
    private String shipperId, shipperName, phone;
   
}