package at.fhv.se.banking.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String iban;
    private Customer owner;
    private double balance;
    private String type;
    private List<Transaction> transactions;

    public String getIban() {
        return iban;
    }

    public Customer getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public String getType() {
        return type;
    }

    public Account(String iban, Customer owner, String type) {
        this.iban = iban;
        this.owner = owner;
        this.balance = 0;
        this.type = type;
        this.transactions = new ArrayList<>();
    }

    public void transferTo(Account receiver, double amount) throws Exception {
        if(amount <= 0) {
            throw new Exception("diebstahl");
        }

        if(this.balance < amount) {
            throw new Exception("armut");
        }

        Transaction tx = new Transaction(this, receiver, amount, LocalDateTime.now());
        this.transactions.add(tx);
        receiver.transactions.add(tx);

        this.balance -= amount;
        receiver.balance += amount;
    }
}
