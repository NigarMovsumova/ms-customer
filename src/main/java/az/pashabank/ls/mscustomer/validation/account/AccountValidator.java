package az.pashabank.ls.mscustomer.validation.account;

import az.pashabank.ls.mscustomer.model.AccountRequest;
import az.pashabank.ls.mscustomer.model.enums.CurrencyCode;
import az.pashabank.ls.mscustomer.util.CheckViolationHelper;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

@Component
public class AccountValidator implements
        ConstraintValidator<AccountConstraint, AccountRequest> {

    private final CheckViolationHelper violationHelper;

    public AccountValidator(CheckViolationHelper violationHelper) {
        this.violationHelper = violationHelper;
    }

    @Override
    public boolean isValid(AccountRequest request, ConstraintValidatorContext context) {
        return isNameValid(request.getName(), context) &&
                isCurrencyValid(request.getCurrency(), context) &&
                isBalanceValid(request.getBalance(), context);
    }

    private boolean isNameValid(String name, ConstraintValidatorContext context) {
        if (name==null || !name.matches("[A-Z][a-z]*")) {
            violationHelper.addViolation(context, "name", "Account Name is not valid");
            return false;
        }
        return true;
    }

    private boolean isBalanceValid(BigDecimal balance, ConstraintValidatorContext context) {
        if (balance == null || balance.compareTo(BigDecimal.ZERO) < 0) {
            violationHelper.addViolation(context, "balance", "Balance is not valid");
            return false;
        }
        return true;
    }

    private boolean isCurrencyValid(String currency, ConstraintValidatorContext context) {
        if (currency==null || !EnumUtils.isValidEnum(CurrencyCode.class, currency)) {
            violationHelper.addViolation(context, "currency", "Currency is not valid");
            return false;
        }
        return true;
    }
}
