package az.pashabank.ls.mscustomer.service;

import az.pashabank.ls.mscustomer.dao.entity.CustomerEntity;
import az.pashabank.ls.mscustomer.model.CustomerRequest;
import az.pashabank.ls.mscustomer.model.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto getCustomerById(Long id);

    void createCustomer(CustomerRequest customerRequest);

    void deleteCustomer(Long id);

    void updateCustomer(Long id, CustomerRequest customerRequest);
}
