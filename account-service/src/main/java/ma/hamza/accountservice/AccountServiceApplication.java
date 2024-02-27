package ma.hamza.accountservice;

import ma.hamza.accountservice.client.CustomerRestClient;
import ma.hamza.accountservice.entity.BankAccount;
import ma.hamza.accountservice.entity.Enum.AccountType;
import ma.hamza.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        return args -> {
            customerRestClient.allCustomers().forEach(customer -> {
                BankAccount bankAccount = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .currency("ER")
                        .balance(8989)
                        .creatAt(LocalDate.now())
                        .type(AccountType.CURRENT_ACCOUNT)
                        .customerId(customer.getId())
                        .build();
                BankAccount bankAccount1 = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .currency("MAD")
                        .balance(98000)
                        .creatAt(LocalDate.now())
                        .type(AccountType.CURRENT_ACCOUNT)
                        .customerId(customer.getId())
                        .build();
                bankAccountRepository.save(bankAccount1);
                bankAccountRepository.save(bankAccount);
            });

        };
    }
}