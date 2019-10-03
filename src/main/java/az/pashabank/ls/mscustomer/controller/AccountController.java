package az.pashabank.ls.mscustomer.controller;

import az.pashabank.ls.mscustomer.model.AccountRequest;
import az.pashabank.ls.mscustomer.model.dto.AccountDto;
import az.pashabank.ls.mscustomer.service.AccountService;
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

import java.util.List;

@RestController
@RequestMapping("/accounts")
@Api("Account Controller")
public class AccountController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/customer/{id}")
    @ApiOperation("get all accounts list by customer id")
    public List<AccountDto> getAllByCustomerId(@PathVariable(name = "id") Long customerId) {
        logger.debug("Get all accounts by customer id");
        return accountService.getAllByCustomerId(customerId);
    }

    @GetMapping("/{id}")
    public AccountDto getAccountById(@PathVariable(name = "id") Long accountId) {
        logger.debug("Get account by customer id");
        return accountService.getAccountById(accountId);
    }

    @PostMapping
    @ApiOperation("create a new account")
    public void createAccount(@RequestBody AccountRequest accountRequest) {
        logger.debug("Create account start");
        accountService.createAccount(accountRequest);
        logger.debug("Create account end");
    }

    @PutMapping("/{id}")
    @ApiOperation("update an account")
    public void updateAccount(@PathVariable Long id, @RequestBody AccountDto accountDto) {
        logger.debug("Update account start");
        accountService.updateAccount(id, accountDto);
        logger.debug("Update account of id {} end", id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("delete an account")
    public void deleteAccount(@PathVariable Long id) {
        logger.debug("Delete an account with id {}", id);
        accountService.deleteAccount(id);
        logger.debug("Delete account with id {} end", id);
    }
}
