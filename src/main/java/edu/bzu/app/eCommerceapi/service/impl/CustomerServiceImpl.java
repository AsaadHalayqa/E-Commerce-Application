package edu.bzu.app.eCommerceapi.service.impl;

import edu.bzu.app.eCommerceapi.dto.CustomerDto;
import edu.bzu.app.eCommerceapi.entity.Customer;
import edu.bzu.app.eCommerceapi.exception.ResourceNotFoundException;
import edu.bzu.app.eCommerceapi.repository.CustomerRepository;
import edu.bzu.app.eCommerceapi.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service //To enable this class for component scanning
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        // convert DTO to entity
        Customer customer = mapToEntity(customerDto);
        Customer newCustomer = customerRepository.save(customer);

        // convert entity to DTO
        CustomerDto customerResponse = mapToDTO(newCustomer);

        return customerResponse;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();

        return customers.stream().map(customer -> mapToDTO(customer)).collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerById(long id) {
        Customer customer = customerRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        return mapToDTO(customer);
    }

    @Override
    public CustomerDto updatCustomer(CustomerDto customerDto, long id) {
        // get Customer by id from the database
        Customer customer = customerRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));

        customer.setName(customerDto.getName());
        customer.setAddress(customerDto.getAddress());
        customer.setCity(customerDto.getCity());
        customer.setCreditCard(customerDto.getCreditCard());
        customer.setEmail(customerDto.getEmail());
        customer.setPhoneNo(customerDto.getPhoneNo());

        Customer updateCustomer = customerRepository.save(customer);

        return mapToDTO(updateCustomer);
    }

    @Override
    public void deleteCustomerById(long id) {
        // get Customer by id from the database
        Customer customer = customerRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        customerRepository.delete(customer);
    }


    // convert Entity into DTO
    private CustomerDto mapToDTO(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setAddress(customer.getAddress());
        customerDto.setCity(customer.getCity());
        customerDto.setCreditCard(customer.getCreditCard());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPhoneNo(customer.getPhoneNo());

        return customerDto;
    }

    // convert DTO to entity
    private Customer mapToEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setName(customerDto.getName());
        customer.setAddress(customerDto.getAddress());
        customer.setCity(customerDto.getCity());
        customer.setCreditCard(customerDto.getCreditCard());
        customer.setEmail(customerDto.getEmail());
        customer.setPhoneNo(customerDto.getPhoneNo());

        return customer;
    }

}








