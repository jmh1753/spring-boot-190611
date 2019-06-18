package com.bit.web.controller;

import java.util.HashMap;

import com.bit.web.domain.CustomerDTO;
import com.bit.web.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * CustomerController
 */
@RestController 
@RequestMapping("/customers") 
public class CustomerController {
    @Autowired CustomerService customerService;
    @Autowired CustomerDTO customer;
    

    @RequestMapping("/count")  //루트 URL
    public String count() {
        System.out.println("CustomerController count() 경로로 들어옴");
        int count = customerService.countAll();
        System.out.println("고객의 총인원 : " + count);
        return "총 고객수 : "+count+"";  //views에 customer.html이아닌 제이슨으로 바뀜, 주소를 넘기는게 아닌 데이터를 넘김     대신에 받는쪽에서 ajax사용
    }  
    
    @GetMapping("/{customerId}/{password}")
    public CustomerDTO login(@PathVariable("customerId")String id,
                        @PathVariable("password")String pass){
        customer.setCustomerId(id);
        customer.setPassword(pass);
        return customerService.login(customer); 
    }

    @PostMapping("")
    public HashMap<String,Object> join(@RequestBody CustomerDTO param){
        System.out.println("=====post mapping======");
        System.out.println(param.getCustomerId());
        System.out.println(param.getPassword());
        System.out.println(param.getCustomerName());
        System.out.println(param.getSsn());
        System.out.println(param.getPhone());
        System.out.println(param.getCity());
        System.out.println(param.getAddress());
        System.out.println(param.getPostalcode());

        HashMap<String,Object> map = new HashMap<>();

        customer.setCustomerId(param.getCustomerId());
        customer.setPassword(param.getPassword());
        customer.setCustomerName(param.getCustomerName());
        customer.setSsn(param.getSsn());
        customer.setPhone(param.getPhone());
        customer.setCity(param.getCity());
        customer.setAddress(param.getAddress());
        customer.setPostalcode(param.getPostalcode());

        customerService.insertCustomer(customer);
        
        map.put("result", "SUCCESS");
        return map; 
    }
}