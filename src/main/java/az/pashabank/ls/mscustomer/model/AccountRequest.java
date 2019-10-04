package az.pashabank.ls.mscustomer.model;

import az.pashabank.ls.mscustomer.validation.account.AccountConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@AccountConstraint
public class AccountRequest {
    private String name;
    private String currency;
    private BigDecimal balance;
    private Long customerId;
}
