package az.pashabank.ls.mscustomer.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
