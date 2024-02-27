package ma.hamza.accountservice.repository;

import ma.hamza.accountservice.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount , String> {
}
