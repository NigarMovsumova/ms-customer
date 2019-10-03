package az.pashabank.ls.mscustomer.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Information about account")
public class AccountDto {
    @ApiModelProperty("Id of account")
    private Long id;

    @ApiModelProperty("Id of customer")
    @NotNull
    private String customerId;

    @ApiModelProperty("Name of customer")
    @NotNull
    private String customerName;
}
