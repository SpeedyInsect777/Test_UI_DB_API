package Test_Java.Test_20;

public class BankCustomer {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(100);
        account.deposit(50);
        account.withdraw(25);
        System.out.println(account.getBalance());
    }
}
