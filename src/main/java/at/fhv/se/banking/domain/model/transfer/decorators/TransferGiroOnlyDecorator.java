package at.fhv.se.banking.domain.model.transfer.decorators;

import at.fhv.se.banking.domain.model.account.Account;
import at.fhv.se.banking.domain.model.transfer.TransferException;
import at.fhv.se.banking.domain.model.transfer.TransferService;

public class TransferGiroOnlyDecorator extends TransferServiceDecorator {

    public TransferGiroOnlyDecorator(TransferService component) {
        super(component);
    }

    @Override
    public void transfer(Account from, Account to, double amount) throws TransferException {

        if(!from.type().equals("giro") || !to.type().equals("giro")) {
            throw new TransferException("can only transfer between Giro accounts");
        }

        super.transfer(from, to, amount);
    }
}
