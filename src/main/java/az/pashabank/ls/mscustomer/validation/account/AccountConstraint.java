package az.pashabank.ls.mscustomer.validation.account;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.FIELD, ElementType.TYPE})
@Constraint(validatedBy = AccountValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface AccountConstraint {
    String message() default "Account request validation error";

    Class[] groups() default {};

    Class[] payload() default {};

    String[] sortingFields() default {};
}
