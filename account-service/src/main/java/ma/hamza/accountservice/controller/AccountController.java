package ma.hamza.accountservice.controller;

import ma.hamza.accountservice.client.CustomerRestClient;
import ma.hamza.accountservice.entity.BankAccount;
import ma.hamza.accountservice.model.Customer;
import ma.hamza.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;
    public AccountController(BankAccountRepository bankAccountRepository,CustomerRestClient customerRestClient){
        this.customerRestClient=customerRestClient;
        this.bankAccountRepository= bankAccountRepository;
    }

    @GetMapping("/accounts")
    public List<BankAccount> accountList (){
        List<BankAccount> accountList = bankAccountRepository.findAll();
        accountList.forEach(acc -> {
            acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));

        });
        return accountList;
    }
    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id){
        BankAccount bankAccount = bankAccountRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
