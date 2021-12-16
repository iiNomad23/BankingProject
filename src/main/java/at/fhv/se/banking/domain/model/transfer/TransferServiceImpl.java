package at.fhv.se.banking.domain.model.transfer;

import at.fhv.se.banking.domain.model.account.Account;

public class TransferServiceImpl implements TransferService {

    @Override
    public void transfer(Account from, Account to, double amount) throws TransferException {
        from.transferTo(to, amount);
    }
}
