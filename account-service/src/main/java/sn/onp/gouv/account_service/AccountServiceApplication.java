package sn.onp.gouv.account_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import sn.onp.gouv.account_service.clients.CustomerRestClient;
import sn.onp.gouv.account_service.entities.BankAccount;
import sn.onp.gouv.account_service.enumeration.AccountType;
import sn.onp.gouv.account_service.model.Customer;
import sn.onp.gouv.account_service.repository.BankAccountRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@EnableFeignClients
@SpringBootApplication
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
		return args -> {
			List<Customer> allCustomers = customerRestClient.customerList();
					allCustomers.forEach(customer -> {
				BankAccount bankAccount1 = BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.currency("MAD")
						.balance(Math.random()*80000)
						.createdAt(LocalDate.now())
						.type(AccountType.CURRENT_ACCOUNT)
						.customerId(customer.getId())
						.build();

				BankAccount bankAccount2 = BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.currency("MAD")
						.balance(Math.random()*65432)
						.createdAt(LocalDate.now())
						.type(AccountType.SAVING_ACCOUNT)
						.customerId(customer.getId())
						.build();
				bankAccountRepository.save(bankAccount1);
				bankAccountRepository.save(bankAccount2);
			});



		};

	}


}
