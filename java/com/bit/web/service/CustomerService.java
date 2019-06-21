package com.bit.web.service;

import java.util.List;

import com.bit.web.common.util.PageProxy;
import com.bit.web.domain.CustomerDTO;

import org.springframework.stereotype.Component;

/**
 * CustomerService
 */
@Component //타입지정
public interface CustomerService {
    public void insertCustomer(CustomerDTO customer);    
    public List<CustomerDTO> findCustomers(PageProxy pxy);
    public List<CustomerDTO> findCustomersByOption(CustomerDTO option);
    public CustomerDTO findCustomerBycustomerId(String customerId);
    public int updateCustomer(CustomerDTO customer);
    public void deleteCustomer(CustomerDTO customer);
    public int countAll();
    
    public CustomerDTO login(CustomerDTO customer);
}