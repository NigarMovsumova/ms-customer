package az.pashabank.ls.mscustomer.model.dto;

import az.pashabank.ls.mscustomer.validation.customer.CustomerConstraint;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@CustomerConstraint
@ApiModel("Information about customer")
public class CustomerDto {

    @ApiModelProperty("Id of customer")
    private Long id;

    @ApiModelProperty("Name of customer")
    @NotNull
    private String name;

    @ApiModelProperty("Surname of customer")
    @NotNull
    private String surname;

    @ApiModelProperty("Customer's accounts list")
    private Set<AccountDto> accountDtoSet;
}
