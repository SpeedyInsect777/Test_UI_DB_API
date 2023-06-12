package Test_Java.Test_05;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test_02 {
    public static void main(String[] args) {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        Workbook workbook = null;
        Sheet sheet;
        String str = "src/test/resources/excelFiles/Test_01_BudgetExcelFileTest.xlsx";

        try {
            fileInputStream = new FileInputStream(str);
            workbook = WorkbookFactory.create(fileInputStream);
            sheet = workbook.getSheet("Employees");
            Row row = sheet.getRow(4);
            System.out.println(row.getCell(1));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try
                {
                    if(fileInputStream!=null){
                    fileInputStream.close();}
                    if(workbook!=null){
                    workbook.close();}
                    if(fileOutputStream!=null){
                    fileOutputStream.close();}
                }catch(IOException e){
e.printStackTrace();
                }
            }
    }
}