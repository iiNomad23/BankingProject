package at.fhv.se.banking.domain.model.account;

import at.fhv.se.banking.domain.model.Customer;
import at.fhv.se.banking.domain.model.transfer.Transaction;
import at.fhv.se.banking.domain.model.transfer.TransferException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Account {

    public static final int OVERDRAFT_LIMIT = 1000;
    public static final int INTEREST_THRESHOLD = 1000;
    public static final double INTEREST_RATE = 0.02;

    private AccountState state;

    private String iban;
    private Customer owner;
    private double balance;
    private String type;
    private List<Transaction> transactions;

    public String iban() {
        return iban;
    }

    public Customer getOwner() {
        return owner;
    }

    public double balance() {
        return balance;
    }

    public String type() {
        return type;
    }

    public Account(String iban, Customer owner, String type) {
        this.iban = iban;
        this.owner = owner;
        this.balance = 0;
        this.type = type;
        this.transactions = new ArrayList<>();
    }

    void changeState(AccountState state) {
        this.state = state;
    }

    public void deposit(double amount) throws Exception {
        if(amount <= 0) {
            throw new Exception("negativ");
        }

        this.balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        if(amount <= 0) {
            throw new Exception("negativ");
        }

        this.balance -= amount;
    }

    public void transferTo(Account receiver, double amount) throws TransferException {
        if(amount <= 0) {
            throw new TransferException("diebstahl");
        }

        if(this.balance < amount) {
            throw new TransferException("armut");
        }

        Transaction tx = new Transaction(this, receiver, amount, LocalDateTime.now());
        this.transactions.add(tx);
        receiver.transactions.add(tx);

        this.balance -= amount;
        receiver.balance += amount;
    }
}
