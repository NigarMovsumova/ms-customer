package az.pashabank.ls.mscustomer.util;

import az.pashabank.ls.mscustomer.controller.CustomerController;
import az.pashabank.ls.mscustomer.model.CustomerRequest;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandomCustomerUtil {

    private static final Logger logger = LoggerFactory.getLogger(RandomCustomerUtil.class);

    public static CustomerRequest buildRandomCustomer() {
        logger.info("ActionLog.buildRandomCustomer.start");
        Faker faker = new Faker();
        CustomerRequest customerRequest = new CustomerRequest();
        customerRequest.setName(faker.name().firstName());
        customerRequest.setSurname(faker.name().lastName());
        logger.info("ActionLog.buildRandomCustomer.success");
        return customerRequest;
    }
}
