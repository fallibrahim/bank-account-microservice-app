package sn.onp.gouv.account_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.onp.gouv.account_service.entities.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, String>   {
}
