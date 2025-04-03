package sn.onp.gouv.account_service.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sn.onp.gouv.account_service.clients.CustomerRestClient;
import sn.onp.gouv.account_service.entities.BankAccount;
import sn.onp.gouv.account_service.model.Customer;
import sn.onp.gouv.account_service.repository.BankAccountRepository;


import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@RestController
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient  customerRestClient;

    public AccountRestController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;;
        this.customerRestClient = customerRestClient;;
    }

    @GetMapping("/accounts")
    public List<BankAccount> accountList()  {
       List<BankAccount> accountList =  bankAccountRepository.findAll();
       accountList.forEach(acc -> {
           acc.setCustomer(customerRestClient.getCustomerById(acc.getCustomerId()));
       });
       return accountList;
    }
    @GetMapping("/accounts/{id}")
    public BankAccount findAccountById(@PathVariable String id) {
        BankAccount bankAccount =  bankAccountRepository.findById(id).get();
        Customer customer = customerRestClient.getCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
