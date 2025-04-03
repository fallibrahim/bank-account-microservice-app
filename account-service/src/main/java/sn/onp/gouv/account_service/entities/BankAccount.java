package sn.onp.gouv.account_service.entities;

import jakarta.persistence.*;
import lombok.*;
import sn.onp.gouv.account_service.enumeration.AccountType;
import sn.onp.gouv.account_service.model.Customer;

import java.time.LocalDate;
@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String id;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;


}
