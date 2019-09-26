package az.pashabank.ls.mscustomer.service;

import az.pashabank.ls.mscustomer.model.CustomerRequest;
import az.pashabank.ls.mscustomer.model.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> getAllCustomers();

    CustomerDto getCustomerById(Long id);

    void createCustomer(CustomerRequest customerRequest);

    void deleteCustomer(Long id);

    void updateCustomer(Long id, CustomerDto customerDto);

}
