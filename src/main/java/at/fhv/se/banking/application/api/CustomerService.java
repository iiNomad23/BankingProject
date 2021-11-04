package at.fhv.se.banking.application.api;

import at.fhv.se.banking.application.dto.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<CustomerDTO> getAll();

    Optional<CustomerDTO> getById(String id);

}
