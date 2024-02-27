package ma.hamza.accountservice.entity;

import jakarta.persistence.*;
import lombok.*;
import ma.hamza.accountservice.entity.Enum.AccountType;
import ma.hamza.accountservice.model.Customer;

import java.time.LocalDate;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate creatAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;
}
