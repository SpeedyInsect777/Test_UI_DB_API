package Test_Java.Test_06;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test_01 {

    @Test
    public void test01() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("src/test/resources/excelFiles/Test_01_BudgetExcelFileTest.xlsx");
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        FileOutputStream fileOutputStream = new FileOutputStream("src/test/resources/excelFiles/Test_01_BudgetExcelFileTest.xlsx");
        workbook.createSheet("Employees");
        workbook.write(fileOutputStream);
        workbook.close();
        fileInputStream.close();
        fileOutputStream.close();

    }

    @Test
    public void test02() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("src/test/resources/excelFiles/Test_01_BudgetExcelFileTest.xlsx");
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("Employees");
        FileOutputStream fileOutputStream = new FileOutputStream("src/test/resources/excelFiles/Test_01_BudgetExcelFileTest.xlsx");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Firstname");
        row = sheet.createRow(1);
        cell = row.createCell(0);
        cell.setCellValue("Mike");
        workbook.write(fileOutputStream);
        fileInputStream.close();
        workbook.close();
    }
    @Test
    public void test03() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("src/test/resources/excelFiles/Test_01_BudgetExcelFileTest.xlsx");
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("Employees");
        FileOutputStream fileOutputStream = new FileOutputStream("src/test/resources/excelFiles/Test_01_BudgetExcelFileTest.xlsx");
//sheet.createRow(1).createCell(0).setCellValue("Name");         NOT CORRECT WAY
// sheet.createRow(2).createCell(1).setCellValue("Lastname");    NOT CORRECT WAY
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("Name");
        row.createCell(1).setCellValue("Lastname");
        row = sheet.createRow(1);
        row.createCell(0).setCellValue("Mike");
        row.createCell(1).setCellValue("Tyson");
        workbook.write(fileOutputStream);
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();
    }

    @Test
    public void test04() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("src/test/resources/excelFiles/Test_01_BudgetExcelFileTest.xlsx");
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("Employees");
        FileOutputStream fileOutputStream = new FileOutputStream("src/test/resources/excelFiles/Test_01_BudgetExcelFileTest.xlsx");
        Row row = sheet.createRow(2);
        row.createCell(0).setCellValue("Joe");
        row.createCell(1).setCellValue("Rogan");
        workbook.write(fileOutputStream);
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();


    }
    @Test
    public void test05(){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("src/test/resources/excelFiles/Test_01_BudgetExcelFileTest.xlsx");
            // Write to the file here
           // workbook.write(fileOutputStream);
        } catch (Exception e) {
            // Handle the exception here
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    // Handle the exception here
                }
            }
        }

    }
}

