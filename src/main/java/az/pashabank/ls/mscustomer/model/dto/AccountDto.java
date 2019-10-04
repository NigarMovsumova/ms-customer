package az.pashabank.ls.mscustomer.model.dto;

import az.pashabank.ls.mscustomer.validation.account.AccountConstraint;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

//TODO MAYBE DELETE THIS DTO ?
@Data
@AllArgsConstructor
@NoArgsConstructor
@AccountConstraint
@ApiModel("Information about account")
@Builder
public class AccountDto {
    @ApiModelProperty("Id of account")
    private Long id;

    @ApiModelProperty("Name of account")
    @NotNull
    private String name;

    @ApiModelProperty("Mapped Customer")
    private CustomerDto customerDto;
}
