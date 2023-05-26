package Test_Java.Test_10;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class Test_01 extends Thread {

    private String filePath = "src/test/resources/excelFiles/Test_01.xlsx";
     private String result;

    public void run() {

        FileInputStream fileInputStream = null;

        Workbook workbook = null;


        try {
            fileInputStream = new FileInputStream(filePath);
            workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheet("Employees");
            Row row = sheet.getRow(0);
            Cell cell = row.getCell(0);
            result= cell.getStringCellValue();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
                workbook.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        System.out.println(result);
    }

}