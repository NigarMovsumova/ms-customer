package az.pashabank.ls.mscustomer.exception;

public class NotFoundException extends CustomerException {

    public NotFoundException(String type) {
        super("exception.ms-customer." + type + "-not-related-to-bank",
                "exception.ms-customer." + type + "-not-related-to-bank");
    }

    public NotFoundException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
