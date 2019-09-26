package az.pashabank.ls.mscustomer.dao;

import az.pashabank.ls.mscustomer.dao.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
