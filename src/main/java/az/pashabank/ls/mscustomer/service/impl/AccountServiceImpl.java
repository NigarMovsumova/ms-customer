package az.pashabank.ls.mscustomer.service.impl;

import az.pashabank.ls.mscustomer.dao.AccountRepository;
import az.pashabank.ls.mscustomer.dao.CustomerRepository;
import az.pashabank.ls.mscustomer.dao.entity.AccountEntity;
import az.pashabank.ls.mscustomer.dao.entity.CustomerEntity;
import az.pashabank.ls.mscustomer.exception.NotFoundException;
import az.pashabank.ls.mscustomer.mappers.AccountMapper;
import az.pashabank.ls.mscustomer.model.AccountRequest;
import az.pashabank.ls.mscustomer.model.dto.AccountDto;
import az.pashabank.ls.mscustomer.service.AccountService;
import az.pashabank.ls.mscustomer.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    public AccountServiceImpl(AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<AccountDto> getAllByCustomerId(Long customerId) {
        return AccountMapper.INSTANCE.mapEntityListToDtoList(accountRepository.findAllByCustomerId(customerId));
    }

    @Override
    public AccountDto getAccountById(Long accountId) {
        return AccountMapper.INSTANCE.mapEntityToDto(
                accountRepository.findById(accountId)
                        //TODO change with normal exception
                        .orElseThrow(() -> new NotFoundException()));
    }

    @Override
    public void createAccount(AccountRequest accountRequest) {
        logger.info("ActionLog.createAccount.start");
        CustomerEntity customerEntity = customerRepository
                .findById(accountRequest.getCustomerId())
                .orElseThrow(() -> new NotFoundException());

        AccountEntity accountEntity = AccountMapper.INSTANCE.mapDtoToEntity(accountRequest);

        accountEntity.setCustomer(customerEntity);
        accountRepository.save(accountEntity);
        logger.info("ActionLog.createAccount.success");

    }

    @Override
    public void deleteAccount(Long id) {
        logger.info("ActionLog.deleteAccount.start");
        accountRepository.deleteById(id);
        logger.info("ActionLog.deleteAccount.success with id: {}", id);
    }

    @Override
    public void updateAccount(Long id, String name) {
        //TODO change exception type
        AccountEntity accountEntity = accountRepository.findById(id).orElseThrow(() -> new NotFoundException());
        accountEntity.setName(name);
        accountRepository.save(accountEntity);
        System.out.println("done");
    }
}
