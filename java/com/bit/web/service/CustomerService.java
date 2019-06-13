package com.bit.web.service;

import java.util.List;

import com.bit.web.domain.CustomerDTO;

import org.springframework.stereotype.Component;

/**
 * CustomerService
 */
@Component //타입지정
public interface CustomerService {
    public void addCustomer(CustomerDTO customer);    
    public List<CustomerDTO> findCustomers();
    public List<CustomerDTO> findCustomersByOption(CustomerDTO option);
    public CustomerDTO findCustomerBycustomerId(String customerId);
    public void updateCustomer(CustomerDTO customer);
    public void deleteCustomer(CustomerDTO customer);
}