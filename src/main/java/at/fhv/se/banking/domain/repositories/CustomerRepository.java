package at.fhv.se.banking.domain.repositories;

import at.fhv.se.banking.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    List<Customer> getAllCustomers();
    Optional<Customer> getByNumber(String customerNumber);
}
