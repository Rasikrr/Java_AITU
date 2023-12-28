package main.models;

public interface Payable {
    double getPaymentAmount() throws LowGpaException;
}
