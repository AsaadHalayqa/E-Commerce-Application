package edu.bzu.app.eCommerceapi.service;

import edu.bzu.app.eCommerceapi.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto createCustomer(CustomerDto CustomerDto);

    List<CustomerDto> getAllCustomers();

    CustomerDto getCustomerById(long id);

    CustomerDto updatCustomer(CustomerDto customerDto ,long id);

    void deleteCustomerById(long id);


}
