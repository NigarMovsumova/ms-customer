package az.pashabank.ls.mscustomer.service;

import az.pashabank.ls.mscustomer.model.AccountRequest;
import az.pashabank.ls.mscustomer.model.CustomerRequest;
import az.pashabank.ls.mscustomer.model.dto.AccountDto;
import az.pashabank.ls.mscustomer.model.dto.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AccountService {

    List<AccountDto> getAllByCustomerId(Long customerId);

    void createAccount(AccountRequest accountRequest);

    void deleteAccount(Long id);

    void updateAccount(Long id, AccountDto accountDto);

    AccountDto getAccountById(Long accountId);
}
