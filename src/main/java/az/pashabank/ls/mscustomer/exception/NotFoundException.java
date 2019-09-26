package az.pashabank.ls.mscustomer.exception;

public class NotFoundException extends CustomerException {

    public NotFoundException() {
        super("exception.ms-customer.customer-not-related-to-company",
                "exception.ms-customer.customer-not-related-to-company");
    }

    public NotFoundException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
