package at.fhv.se.banking.domain.model.transfer.decorators;

import at.fhv.se.banking.domain.model.account.Account;
import at.fhv.se.banking.domain.model.transfer.TransferException;
import at.fhv.se.banking.domain.model.transfer.TransferService;

public class TransferLoggerDecorator extends TransferServiceDecorator {

    public TransferLoggerDecorator(TransferService component) {
        super(component);
    }

    @Override
    public void transfer(Account from, Account to, double amount) throws TransferException {

        System.out.println("attempting to transfer " + amount + " from " + from + " to " + to);

        try {
            super.transfer(from, to, amount);
            System.out.println("succeeded");
        } catch (TransferException x) {
            System.out.println("tx failed:");
            x.printStackTrace();
        }
    }
}
