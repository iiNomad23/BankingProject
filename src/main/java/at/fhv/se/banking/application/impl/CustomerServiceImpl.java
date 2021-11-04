package at.fhv.se.banking.application.impl;

import at.fhv.se.banking.application.api.CustomerService;
import at.fhv.se.banking.application.dto.CustomerDTO;
import at.fhv.se.banking.application.dto.CustomerDetailsDTO;
import at.fhv.se.banking.domain.model.Customer;
import at.fhv.se.banking.domain.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerDTO> getAll() {
        return customerRepository.getAllCustomers().stream().map(c -> CustomerDTO.builder()
                .withId(c.getCustomerNumber())
                .withName(c.getName()).build())
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Optional<CustomerDetailsDTO> getById(String id) {
        Optional<Customer> result = customerRepository.getByNumber(id);
        if(result.isEmpty()) {
            return Optional.empty();
        }

        Customer customer = result.get();

        return Optional.of(CustomerDetailsDTO.builder()
                .withCustomer(CustomerDTO.builder()
                        .withId(customer.getCustomerNumber())
                        .withName(customer.getName())
                .build()).build());
    }
}
