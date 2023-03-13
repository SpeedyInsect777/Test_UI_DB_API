package Test_Java.Test_08;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.bouncycastle.util.IPAddress;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test_02 {

    @Test
    public void main() {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        Workbook workbook = null;
        try {
            fileInputStream = new FileInputStream("src/test/resources/excelFiles/Test_01.xlsx");
            workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheet("Employees");
            fileOutputStream = new FileOutputStream("src/test/resources/excelFiles/Test_01.xlsx");
            Row row = sheet.createRow(0);
            row.createCell(0).setCellValue("Name");
            workbook.write(fileOutputStream);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (workbook != null) {
                    workbook.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
    @Test
    public void test02(){
FileInputStream fileInputStream=null;
FileOutputStream fileOutputStream =null;
Workbook workbook = null;

try{
    fileInputStream = new FileInputStream("src/test/resources/excelFiles/Test_01.xlsx");
    workbook =  WorkbookFactory.create(fileInputStream);
    Sheet sheet = workbook.getSheet("Employees");
    Row row = sheet.createRow(0);
    row.createCell(0).setCellValue("Name");
    fileOutputStream = new FileOutputStream("src/test/resources/excelFiles/Test_01.xlsx");
    workbook.write(fileOutputStream);

}catch (IOException e){
    System.out.println(e);
}
finally {
    try {
        if(fileInputStream!=null){
            fileInputStream.close();
        }if(workbook!=null){
            workbook.close();
        }if(fileOutputStream!=null){
            fileOutputStream.close();
        }
    }catch (IOException e){
        System.out.println(e);
    }
}
    }
    @Test
    public void test03(){
        FileInputStream fileInputStream =null;
        FileOutputStream fileOutputStream =null;
        Workbook workbook = null;

        try {
            fileInputStream = new FileInputStream("src/test/resources/excelFiles/Test_01.xlsx");
            workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheet("Employees");
            Row row = sheet.createRow(0);
            row.createCell(1).setCellValue("lastname");
            fileOutputStream = new FileOutputStream("src/test/resources/excelFiles/Test_01.xlsx");
            workbook.write(fileOutputStream);

        }catch (IOException e){
            System.out.println(e);
        }finally {
            try{
                if(fileInputStream!=null){
                    fileInputStream.close();
                }if(fileOutputStream!=null){
                    fileOutputStream.close();
                }if(workbook!=null){
                    workbook.close();
                }
            }catch (IOException e){
                System.out.println(e);
            }
        }
    }
    @Test
    public void test04(){
            
    }
}
