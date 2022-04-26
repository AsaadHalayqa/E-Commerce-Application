package edu.bzu.app.eCommerceapi.controller;

import edu.bzu.app.eCommerceapi.dto.CustomerDto;
import edu.bzu.app.eCommerceapi.exception.BadRequestException;
import edu.bzu.app.eCommerceapi.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/eCommerceApi/customer")
public class CustomerController {
    private final Logger log = LoggerFactory.getLogger(CustomerController.class);


    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto customerDto) {
        if (customerDto.getId() != null) {
            log.error("Cannot have an ID {}", customerDto);
            throw new BadRequestException(CustomerController.class.getSimpleName(), "Id");
        }
        return new ResponseEntity(customerService.createCustomer(customerDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updatCustomer(
            @Valid @RequestBody CustomerDto customerDto, @PathVariable(name = "id") long id) {
        return new ResponseEntity<>(customerService.updatCustomer(customerDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable(name = "id") long id){
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }

}
