package at.fhv.se.banking.domain.model.transfer.decorators;

import at.fhv.se.banking.domain.model.account.Account;
import at.fhv.se.banking.domain.model.transfer.TransferException;
import at.fhv.se.banking.domain.model.transfer.TransferService;

public abstract class TransferServiceDecorator implements TransferService {

    private final TransferService component;

    public TransferServiceDecorator(TransferService component) {
        this.component = component;
    }

    public void transfer(Account from, Account to, double amount) throws TransferException {
        component.transfer(from, to, amount);
    }

}
