package az.pashabank.ls.mscustomer.validation;

import az.pashabank.ls.mscustomer.model.CustomerRequest;
import az.pashabank.ls.mscustomer.util.CheckViolationHelper;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CustomerValidator implements
        ConstraintValidator<CustomerConstraint, CustomerRequest> {

    private final CheckViolationHelper violationHelper;

    public CustomerValidator(CheckViolationHelper violationHelper) {
        this.violationHelper = violationHelper;
    }

    @Override
    public boolean isValid(CustomerRequest customerRequest, ConstraintValidatorContext context) {
        return isNameValid(customerRequest.getName(), context)
                && isSurnameValid(customerRequest.getSurname(), context);
    }

    private boolean isNameValid(String name, ConstraintValidatorContext context) {
        if (name == null) {
            violationHelper.addViolation(context, "name", "Name is not valid");
            return false;
        }

        if (!name.matches("[A-Z][a-z]*")) {
            violationHelper.addViolation(context, "name", "Name is not valid");
            return false;
        }
        return true;
    }

    private boolean isSurnameValid(String surname, ConstraintValidatorContext context) {
        if (surname == null) {
            violationHelper.addViolation(context, "surname", "Surname is not valid");
            return false;
        }
        if (!surname.matches("[A-Z]+([ '-][a-zA-Z]+)*")) {
            violationHelper.addViolation(context, "surname", "Surname is not valid");
            return false;
        }
        return true;
    }
}
