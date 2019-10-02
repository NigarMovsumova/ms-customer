package az.pashabank.ls.mscustomer.scheduler;

import az.pashabank.ls.mscustomer.model.CustomerRequest;
import az.pashabank.ls.mscustomer.service.CustomerService;
import az.pashabank.ls.mscustomer.util.RandomCustomerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Profile("!integration")
public class CustomerScheduler {

    private static final Logger logger = LoggerFactory.getLogger(CustomerScheduler.class);

    private final CustomerService customerService;

    public CustomerScheduler(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Scheduled(cron = "0/15 * * * * *")
    public void createRandomCustomers() {
        logger.info("ActionLog.createRandomCustomers.start");
        CustomerRequest customerRequest= RandomCustomerUtil.buildRandomCustomer();
        System.out.println(customerRequest.toString());
        customerService.createCustomer(customerRequest);

        logger.info("ActionLog.createRandomCustomers.success");
    }
}
