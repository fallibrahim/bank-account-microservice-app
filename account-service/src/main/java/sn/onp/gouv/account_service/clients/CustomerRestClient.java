package sn.onp.gouv.account_service.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sn.onp.gouv.account_service.model.Customer;

import java.util.List;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerRestClient {
   @GetMapping("/customers/{id}")
   @CircuitBreaker(name= "customerService", fallbackMethod = "getDefaultCustomer")
    Customer getCustomerById(@PathVariable Long id);
   @GetMapping("/customers")
   @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomers")
   List<Customer> customerList();

   default Customer getDefaultCustomer(Long id, Exception exception) {
       Customer customer = new Customer();
       customer.setId(id);
       customer.setFirstName("Not Vailable");
       customer.setLastName("Not Vailable");
       customer.setEmail("Not Vailable");

       return customer;
   }

   default List<Customer> getDefaultCustomers(Exception e) {
       return List.of();
   }

}
