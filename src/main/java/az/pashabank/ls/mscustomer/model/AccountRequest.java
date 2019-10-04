package az.pashabank.ls.mscustomer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest {
    private String name;
    private String currency;
    private BigDecimal balance;
    private Long customerId;
}
