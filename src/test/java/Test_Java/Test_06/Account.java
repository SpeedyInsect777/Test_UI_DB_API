package Test_Java.Test_06;

public class Account {

    private static int totalAccounts = 0;

    private Integer accountNumber;
    private String fullName;
    private Double balance;
    private Double deposit;

    public Account(Integer accountNumber, String fullName, Double balance) {
        this.accountNumber = accountNumber;
        this.fullName = fullName;
        this.balance = balance;
        totalAccounts++;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        if (deposit < 0) {
            throw new IllegalArgumentException("Deposit cannot be negative");
        } else {
            balance += deposit;
            this.deposit = deposit;
        }
    }


    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        if (accountNumber < 0) {
            throw new IllegalArgumentException("Account number cannot be negative");
        } else {
            this.accountNumber = accountNumber;
        }
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }



    public String toString() {
        return "Account Number: " + accountNumber + "\n" +
                "Full Name: " + fullName + "\n" +
                "Balance: " + balance + "\n" +
                "Total Accounts: " + totalAccounts;
    }
}
