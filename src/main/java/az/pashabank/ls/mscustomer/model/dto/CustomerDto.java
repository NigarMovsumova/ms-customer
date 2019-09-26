package az.pashabank.ls.mscustomer.model.dto;

import az.pashabank.ls.mscustomer.validation.CustomerConstraint;
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
@Builder
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
}
