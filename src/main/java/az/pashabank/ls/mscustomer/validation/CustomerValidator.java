package az.pashabank.ls.mscustomer.validation;

import az.pashabank.ls.mscustomer.model.dto.CustomerDto;
import az.pashabank.ls.mscustomer.util.CheckViolationHelper;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CustomerValidator implements
        ConstraintValidator<CustomerConstraint, CustomerDto> {

    private final CheckViolationHelper violationHelper;

    public CustomerValidator(CheckViolationHelper violationHelper) {
        this.violationHelper = violationHelper;
    }

    @Override
    public boolean isValid(CustomerDto customerDto, ConstraintValidatorContext context) {
        return isNameValid(customerDto.getName(), context)
                && isSurnameValid(customerDto.getSurname(), context);
    }

    private boolean isNameValid(String name, ConstraintValidatorContext context){
        if(!name.matches("[A-Z][a-z]*" )){
            violationHelper.addViolation(context, "name", "Name is not valid");
            return false;
        }
        return true;
    }

    private boolean isSurnameValid(String surname, ConstraintValidatorContext context){
        if (!surname.matches("[A-Z]+([ '-][a-zA-Z]+)*")){
            violationHelper.addViolation(context, "surname", "Surname is not valid");
            return false;
        }
        return true;
    }
}
