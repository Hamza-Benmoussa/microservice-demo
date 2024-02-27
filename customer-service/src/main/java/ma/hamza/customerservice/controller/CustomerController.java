package ma.hamza.customerservice.controller;

import ma.hamza.customerservice.entity.Customer;
import ma.hamza.customerservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerRepository customerRepository;
    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository= customerRepository;
    }

    @GetMapping("/customers")
    public List<Customer> customerList (){
        return customerRepository.findAll();
    }
    @GetMapping("/customers/{id}")
    public Customer customerById(@PathVariable Long id){
        return customerRepository.findById(id).get();
    }
}
