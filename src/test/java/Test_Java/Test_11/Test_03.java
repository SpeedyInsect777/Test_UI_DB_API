package Test_Java.Test_11;

import Test_Java.Test_06.Account;
import org.junit.jupiter.api.Test;
import utilities.ExcelToolBox;

public class Test_03 {

    Account account ;

    String sheetName = "Accounts";
    String path = "src/test/resources/excelFiles/Account.xlsx";
ExcelToolBox excelToolBox ;

    @Test
    public void test_01() {

excelToolBox = new ExcelToolBox(path, sheetName);


      account =  new Account(12345, "Agent  Steve", 1000.00);

        account.setDeposit(230.00);

        System.out.println(account);

        System.out.println("Account Number: " + account.getBalance());

excelToolBox.setExcelData(1, 0, account.getAccountNumber().toString());
excelToolBox.setExcelData(1,1, account.getFullName());
excelToolBox.setExcelData(1,2, account.getBalance().toString());

        System.out.println("==============");
        System.out.println("Account Number: " + excelToolBox.getExcelData(1, 2));
    }
    @Test
    public void test_02() {

        excelToolBox = new ExcelToolBox(path, sheetName);
      account =  new Account(98778, "Oliver Bob", 550.00);

        excelToolBox.setExcelData(3, 0, account.getAccountNumber().toString());
        excelToolBox.setExcelData(3,1, account.getFullName());
        excelToolBox.setExcelData(3,2, account.getBalance().toString());
        System.out.println(account);
    }
    @Test
    public void test_03() {

        excelToolBox = new ExcelToolBox(path, sheetName);
        account =  new Account(333222, "Martin John", 550.00);

        excelToolBox.setExcelData(4, 0, account.getAccountNumber().toString());
        excelToolBox.setExcelData(4,1, account.getFullName());
        excelToolBox.setExcelData(4,2, account.getBalance().toString());
        System.out.println(account);
    }
}

