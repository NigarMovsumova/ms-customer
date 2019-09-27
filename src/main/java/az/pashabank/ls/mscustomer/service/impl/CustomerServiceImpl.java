package az.pashabank.ls.mscustomer.service.impl;

import az.pashabank.ls.mscustomer.controller.CustomerController;
import az.pashabank.ls.mscustomer.dao.CustomerRepository;
import az.pashabank.ls.mscustomer.dao.entity.CustomerEntity;
import az.pashabank.ls.mscustomer.exception.CustomerException;
import az.pashabank.ls.mscustomer.exception.NotFoundException;
import az.pashabank.ls.mscustomer.mappers.CustomerMapper;
import az.pashabank.ls.mscustomer.model.CustomerRequest;
import az.pashabank.ls.mscustomer.model.dto.CustomerDto;
import az.pashabank.ls.mscustomer.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        logger.info("ActionLog.getAllCustomers.start");
        return customerMapper.mapEntityListToDtoList(customerRepository.findAll());
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        logger.info("ActionLog.getCustomerById.start id {}", id);
        return customerMapper.mapEntityToDto(customerRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException()));
    }

    @Override
    public void createCustomer(CustomerRequest customerRequest) {
        logger.info("ActionLog.createCustomer.start");
        customerRepository.save(customerMapper.mapDtoToEntity(customerRequest));
        logger.info("ActionLog.createCustomer.success");
    }

    @Override
    public void updateCustomer(Long id, CustomerDto customerDto) {
        logger.info("ActionLog.updateCustomer.start for customer with id: {}", id);
        CustomerEntity customerEntity= customerRepository.findById(id)
                .orElseThrow(()->new NotFoundException());
        customerEntity.setName(customerDto.getName());
        customerEntity.setSurname(customerDto.getSurname());
        customerRepository.save(customerEntity);
        logger.info("ActionLog.updateCustomer.end for customer with id:{}", id);
    }

    @Override
    public void deleteCustomer(Long id) {
        logger.info("ActionLog.deleteCustomer.start");
        customerRepository.deleteById(id);
        logger.info("ActionLog.deleteCustomer.success with id: {}", id);
    }
}
