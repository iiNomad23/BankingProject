package at.fhv.se.banking;

import at.fhv.se.banking.domain.model.Account;
import at.fhv.se.banking.domain.model.Customer;
import at.fhv.se.banking.domain.repositories.AccountRepository;
import at.fhv.se.banking.domain.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestData implements ApplicationRunner {
    
    // TODO: inject Repositories Interfaces for which to create Test Data
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // TODO: create Test Data and add to injected Repositories

        Customer cust1 = new Customer("1", "Max Mustermann");
        Customer cust2 = new Customer("2", "Maria Musterfrau");

        this.customerRepository.storeAll(List.of(cust1, cust2));

        this.accountRepository.storeAll(List.of(
                new Account("AT12 12345 01234567890", cust1, "Giro"),
                new Account("AT98 54321 09876543210", cust2, "Giro")
        ));
    }

}
