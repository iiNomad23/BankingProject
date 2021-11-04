package at.fhv.se.banking.application.api;

import at.fhv.se.banking.application.dto.AccountDTO;

import java.util.Optional;

public interface AccountService {

    Optional<AccountDTO> getByIban(String iban);

    void deposit(String accountIban, double amount) throws Exception;

    void withdraw(String accountIban, double amount) throws Exception;

    void transfer(String sendingIban, String receivingIban, double amount) throws Exception;

}
