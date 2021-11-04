package at.fhv.se.banking.application.api;

import at.fhv.se.banking.application.dto.AccountDTO;

import java.util.Optional;

public interface AccountService {

    Optional<AccountDTO> getByIban(String iban);

    void deposit(String accountIban, double amount);

    void withdraw(String accountIban, double amount);

    void transfer(String sendingIban, String receivingIban, double amount);

}
