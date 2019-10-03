package az.pashabank.ls.mscustomer.controller;

import az.pashabank.ls.mscustomer.dao.entity.CustomerEntity;
import az.pashabank.ls.mscustomer.model.CustomerRequest;
import az.pashabank.ls.mscustomer.model.dto.CustomerDto;
import az.pashabank.ls.mscustomer.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
@Api("Customer Controller")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @ApiOperation("get all customers list")
    public List<CustomerEntity> getAllCustomers() {
        logger.debug("Get all customers");
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    @ApiOperation("get customer by id")
    public CustomerDto getCustomerById(@PathVariable(name = "id") Long id) {
        logger.debug("Get customer of id {} start", id);
        return customerService.getCustomerById(id);
    }

    @PostMapping
    @ApiOperation("create a new customer")
    public void createCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        logger.debug("Create customer start");
        customerService.createCustomer(customerRequest);
        logger.debug("Create customer end");
    }

    @PutMapping("/{id}")
    @ApiOperation("update a customer")
    public void updateCustomer(@PathVariable Long id, @RequestBody CustomerDto customerDto) {
        logger.debug("Update a customer start");
        customerService.updateCustomer(id, customerDto);
        logger.debug("Update customer of id {} end", id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("delete a customer")
    public void deleteCustomer(@PathVariable Long id) {
        logger.debug("delete a customer with id {}", id);
        customerService.deleteCustomer(id);
        logger.debug("Delete customer with id {} end", id);
    }
}
