package az.pashabank.ls.mscustomer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest {
    private Long id;
    private String name;
    private String currency;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private BigDecimal balance;
}
