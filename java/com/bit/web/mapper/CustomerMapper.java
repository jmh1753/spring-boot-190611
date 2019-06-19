package com.bit.web.mapper;

import java.util.List;

import com.bit.web.domain.CustomerDTO;

import org.springframework.stereotype.Repository;

/**
 * CustomerMapper
 */
@Repository
public interface CustomerMapper {
    public void insertCustomer(CustomerDTO customer);    
    public List<CustomerDTO> selectCustomers();
    public List<CustomerDTO> selectCustomersByOption(CustomerDTO option);
    public CustomerDTO selectCustomerBycustomerId(String customerId);
    public int updateCustomer(CustomerDTO customer);
    public int deleteCustomer(CustomerDTO customer);
    public int selectCount();
    
    public CustomerDTO login(CustomerDTO customer);
    
}