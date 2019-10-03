package az.pashabank.ls.mscustomer.service.impl;

import az.pashabank.ls.mscustomer.dao.AccountRepository;
import az.pashabank.ls.mscustomer.dao.entity.AccountEntity;
import az.pashabank.ls.mscustomer.exception.NotFoundException;
import az.pashabank.ls.mscustomer.mappers.AccountMapper;
import az.pashabank.ls.mscustomer.mappers.CustomerMapper;
import az.pashabank.ls.mscustomer.model.AccountRequest;
import az.pashabank.ls.mscustomer.model.CustomerRequest;
import az.pashabank.ls.mscustomer.model.dto.AccountDto;
import az.pashabank.ls.mscustomer.model.dto.CustomerDto;
import az.pashabank.ls.mscustomer.service.AccountService;
import az.pashabank.ls.mscustomer.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);


    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
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
                .orElseThrow(()-> new NotFoundException()));
    }

    @Override
    public void createAccount(AccountRequest accountRequest) {
        logger.info("ActionLog.createAccount.start");
        accountRepository.save(AccountMapper.INSTANCE.mapDtoToEntity(accountRequest));
        logger.info("ActionLog.createAccount.success");

    }

    @Override
    public void deleteAccount(Long id) {
        logger.info("ActionLog.deleteAccount.start");
        accountRepository.deleteById(id);
        logger.info("ActionLog.deleteAccount.success with id: {}", id);
    }

    @Override
    public void updateAccount(Long id, AccountDto accountDto) {

    }
}
