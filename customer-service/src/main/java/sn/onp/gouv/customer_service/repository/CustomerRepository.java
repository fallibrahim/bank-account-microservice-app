package sn.onp.gouv.customer_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.onp.gouv.customer_service.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
