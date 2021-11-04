package at.fhv.se.banking.domain.model;

public class Customer {
    private String customerNumber;
    private String name;

    public Customer(String customerNumber, String name) {
        this.customerNumber = customerNumber;
        this.name = name;
    }

    public String getCustomerNumber() {
        return this.customerNumber;
    }

    public String getName() {
        return this.name;
    }
}
