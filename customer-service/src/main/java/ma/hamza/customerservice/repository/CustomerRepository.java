package ma.hamza.customerservice.repository;

import ma.hamza.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CustomerRepository extends JpaRepository<Customer ,Long> {
}
