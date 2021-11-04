package at.fhv.se.banking.domain.repositories;

import at.fhv.se.banking.domain.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    Optional<Account> getByIban(String iban);
    List<Account> getByOwnerNumber(String customerNumber);

    void storeAll(List<Account> accounts);
}
