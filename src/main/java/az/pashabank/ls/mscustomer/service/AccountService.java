package az.pashabank.ls.mscustomer.service;

import az.pashabank.ls.mscustomer.model.AccountRequest;
import az.pashabank.ls.mscustomer.model.dto.AccountDto;

import java.util.List;

public interface AccountService {

    List<AccountDto> getAllByCustomerId(Long customerId);

    void createAccount(AccountRequest accountRequest);

    void deleteAccount(Long id);

    void updateAccount(Long id, String name);

    AccountDto getAccountById(Long accountId);
}
