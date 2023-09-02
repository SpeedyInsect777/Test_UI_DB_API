package Test_Java.Test_20;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertEquals;

public class BankAccount {


    private double balance;

    public BankAccount(double initialBalance) {
        if(initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative!");
        }
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative!");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if(amount < 0 || amount > balance) {
            throw new IllegalArgumentException("Invalid withdrawal amount!");
        }
        balance -= amount;
    }
}
