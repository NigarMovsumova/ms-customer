package az.pashabank.ls.mscustomer.dao;

import az.pashabank.ls.mscustomer.dao.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    List<AccountEntity> findAllByCustomerId(Long customerId);
}
