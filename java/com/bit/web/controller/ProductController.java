package com.bit.web.controller;

import com.bit.web.domain.ProductDTO;
import com.bit.web.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProductController
 */
@RestController
public class ProductController {
    @Autowired ProductService productservice;
    @Autowired ProductDTO product;

    
}