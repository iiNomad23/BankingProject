package at.fhv.se.banking.infrastructure;

import at.fhv.se.banking.domain.model.Customer;
import at.fhv.se.banking.domain.repositories.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private List<Customer> customers;

    public CustomerRepositoryImpl() {
        this.customers = new ArrayList<>();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return List.copyOf(customers);
    }

    @Override
    public Optional<Customer> getByNumber(String customerNumber) {
        return customers.stream()
                .filter(c -> c.getCustomerNumber().equals(customerNumber))
                .findFirst();
    }
}
