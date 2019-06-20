package com.bit.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.bit.web.common.util.Printer;
import com.bit.web.domain.CustomerDTO;
import com.bit.web.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    @Autowired Printer p;
    
    @PostMapping("")
    public HashMap<String,Object> join(@RequestBody CustomerDTO param){
        System.out.println("=====post mapping======");
        System.out.println(param.getCustomerId());
        System.out.println(param.getPassword());
        System.out.println(param.getPhone());
        
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

    @GetMapping("")
    public List<CustomerDTO> list(){
        List<CustomerDTO> list = new ArrayList<>();
        //System.out.println("콘솔창에 리스트(고객목록) 나오게하기");

        //list = customerService.findCustomers();
        //for (CustomerDTO customer : list){
        //    System.out.println(list);
        //}
        return list;
    }


    @GetMapping("/count")  //루트 URL
    public String count() {
        System.out.println("CustomerController count() 경로로 들어옴");
        int count = customerService.countAll();
        p.accept("람다가 출력한 고객의 총인원 : " + count);
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



    

    @GetMapping("/{customerId}")
    public CustomerDTO selectCustomer(@PathVariable String customerId) {
        System.out.println("id 검색진입 : " + customerId);
        return customerService.findCustomerBycustomerId(customerId);
    }

    @PutMapping("/{customerId}")
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO param) {
        System.out.println("수정 할 객체: "+param.toString());
        
        //customer.setCustomerId(param.getCustomerId());
        //customer.setPassword(param.getPassword());
        //customer.setCustomerName(param.getCustomerName());
        //customer.setSsn(param.getSsn());
        //customer.setPhone(param.getPhone());
        //customer.setCity(param.getCity());
        //customer.setAddress(param.getAddress());
        //customer.setPostalcode(param.getPostalcode());
        int res = customerService.updateCustomer(param);
        System.out.println("===>" + res);
        if(res ==1 ){
            customer = customerService.findCustomerBycustomerId(param.getCustomerId());
        } else{
            System.out.println("컨트롤러 수정 실패");
        }       
        return customer;
    }

    @DeleteMapping("/{customerId}")
    public HashMap<String, Object> deleteCustomer(@PathVariable String customerId) {
        HashMap<String,Object> map = new HashMap<>();
        customer.setCustomerId(customerId);
        customerService.deleteCustomer(customer);
        map.put("result", "탈퇴성공");
        return map;
    }



  


}