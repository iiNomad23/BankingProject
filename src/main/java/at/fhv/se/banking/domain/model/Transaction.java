package at.fhv.se.banking.domain.model;

import java.time.LocalDateTime;

public class Transaction {
    private final Account sender;
    private final Account receiver;
    private final double amount;
    private final LocalDateTime timestamp;

    public Transaction(Account sender, Account receiver, double amount, LocalDateTime timestamp) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public Account sender() {
        return sender;
    }

    public Account receiver() {
        return receiver;
    }

    public double amount() {
        return amount;
    }

    public LocalDateTime timestamp() {
        return timestamp;
    }
}
