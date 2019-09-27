package az.pashabank.ls.mscustomer.model;

import az.pashabank.ls.mscustomer.validation.CustomerConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@CustomerConstraint
public class CustomerRequest {
    private String name;
    private String surname;
}
