package az.pashabank.ls.mscustomer.service.impl;

import az.pashabank.ls.mscustomer.dao.CustomerRepository;
import az.pashabank.ls.mscustomer.dao.entity.CustomerEntity;
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

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        logger.info("ActionLog.getCustomerById.start id {}", id);
        return CustomerMapper.INSTANCE.mapEntityToDto(customerRepository
                .findById(id)
                .orElseThrow(NotFoundException::new));
    }

    @Override
    public void createCustomer(CustomerRequest customerRequest) {
        logger.info("ActionLog.createCustomer.start");
        customerRepository.save(CustomerMapper.INSTANCE.mapDtoToEntity(customerRequest));
        logger.info("ActionLog.createCustomer.success");
    }

    @Override
    public void updateCustomer(Long id, CustomerRequest customerRequest) {
        logger.info("ActionLog.updateCustomer.start for customer with id: {}", id);
        CustomerEntity customerEntity = customerRepository
                .findById(id)
                .orElseThrow(NotFoundException::new);

        if (customerRequest.getName() != null) {
            customerEntity.setName(customerRequest.getName());
        }

        if (customerRequest.getSurname() != null) {
            customerEntity.setSurname(customerRequest.getSurname());
        }

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
