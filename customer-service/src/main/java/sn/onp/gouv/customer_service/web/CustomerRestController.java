package sn.onp.gouv.customer_service.web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import sn.onp.gouv.customer_service.entities.Customer;
import sn.onp.gouv.customer_service.repository.CustomerRepository;

import java.util.List;

@AllArgsConstructor
@RestController
public class CustomerRestController {
    private CustomerRepository customerRepository;


   @GetMapping("/customers")
   public List<Customer> customerList() {
       return customerRepository.findAll();
   }
   @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
       return customerRepository.findById(id)
               .map(ResponseEntity::ok)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found with ID: " + id));

   }
}
