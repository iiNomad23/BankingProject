package at.fhv.se.banking.application.api;

import at.fhv.se.banking.application.dto.CustomerDTO;
import at.fhv.se.banking.application.dto.CustomerDetailsDTO;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<CustomerDTO> getAll();

    Optional<CustomerDetailsDTO> getById(String id);

}
