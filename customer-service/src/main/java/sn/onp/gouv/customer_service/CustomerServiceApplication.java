package sn.onp.gouv.customer_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import sn.onp.gouv.customer_service.config.GlobalConfig;
import sn.onp.gouv.customer_service.entities.Customer;
import sn.onp.gouv.customer_service.repository.CustomerRepository;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
    @Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			List<Customer> customerList = List.of(
					Customer.builder()
					.firstName("Ibrahima")
					.lastName("FALL")
					.email("ibrahimafall095@gmail.com")
					.build(),
					Customer.builder()
					.firstName("Assane")
					.lastName("FALL")
					.email("assanefall@gmail.com")
					.build()


			);
			customerRepository.saveAll(customerList);

		};
	}

}
