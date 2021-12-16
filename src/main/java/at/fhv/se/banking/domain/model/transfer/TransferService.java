package at.fhv.se.banking.domain.model.transfer;

import at.fhv.se.banking.domain.model.account.Account;

public interface TransferService {

    void transfer(Account from, Account to, double amount) throws TransferException;

}
