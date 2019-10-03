package az.pashabank.ls.mscustomer.validation.account;

import az.pashabank.ls.mscustomer.model.CustomerRequest;
import az.pashabank.ls.mscustomer.util.CheckViolationHelper;
import az.pashabank.ls.mscustomer.validation.customer.CustomerConstraint;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class AccountValidator implements
        ConstraintValidator<CustomerConstraint, CustomerRequest> {

    private final CheckViolationHelper violationHelper;

    public AccountValidator(CheckViolationHelper violationHelper) {
        this.violationHelper = violationHelper;
    }

    @Override
    public boolean isValid(CustomerRequest value, ConstraintValidatorContext context) {
        return false;
    }
}
