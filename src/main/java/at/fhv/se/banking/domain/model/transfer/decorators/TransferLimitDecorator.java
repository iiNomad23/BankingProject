package at.fhv.se.banking.domain.model.transfer.decorators;

import at.fhv.se.banking.domain.model.account.Account;
import at.fhv.se.banking.domain.model.transfer.TransferException;
import at.fhv.se.banking.domain.model.transfer.TransferService;

public class TransferLimitDecorator extends TransferServiceDecorator {

    private double limit = 5000.00;

    public TransferLimitDecorator(TransferService component, double limit) {
        super(component);
        this.limit = limit;
    }

    @Override
    public void transfer(Account from, Account to, double amount) throws TransferException {

        if(amount > limit) {
            throw new TransferException("maximum of " + limit);
        }

        super.transfer(from, to, amount);

    }
}
