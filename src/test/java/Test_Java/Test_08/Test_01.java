package Test_Java.Test_08;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;



public class Test_01 {
    @Test
    public void test01() {

        FileInputStream fileInputStream = null;
        Workbook workbook = null;
        Sheet sheet;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream("src/test/resources/excelFiles/Test_01.xlsx");
            workbook = WorkbookFactory.create(fileInputStream);
            sheet = workbook.getSheet("Employees");

            Row row = sheet.createRow(4);
            row.createCell(0).setCellValue("Mike");
            row.createCell(1).setCellValue("Tyson");

            fileOutputStream = new FileOutputStream("src/test/resources/excelFiles/Test_01.xlsx");
            workbook.write(fileOutputStream);


        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                System.out.println("Finally is running...");
                if (fileInputStream != null) {
                    fileInputStream.close();
                }else
                if (workbook != null) {
                    workbook.close();
                }else
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
    }

