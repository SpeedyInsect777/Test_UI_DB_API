package Test_Java.Test_06;

public class OnlineAccount {

    public static void main(String[] args) {


        Account account = new Account(123456, "John Doe", 100.0);
        System.out.println("Account number: " + account.getAccountNumber());
        System.out.println("Full name: " + account.getFullName());
        System.out.println("Balance: " + account.getBalance());
        account.setDeposit(50.0);
        System.out.println("Deposit: " + account.getDeposit());
        System.out.println("Balance: " + account.getBalance());

    }
}
