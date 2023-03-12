package Test_Java.Test_05;

import io.cucumber.java.sl.Ce;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test_01 {

    @Test
    public void test01() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("src/test/resources/excelFiles/LibraryTest.xlsx");

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheet("Library1");

        Row row = sheet.getRow(3);

        Cell cell = row.getCell(3);

        System.out.println(cell.getStringCellValue());

        System.out.println(workbook.getNumberOfSheets());

        System.out.println(workbook.getSheetAt(6).getSheetName());

        fileInputStream.close();

        workbook.close();

    }

    @Test
    public void test02() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("src/test/resources/excelFiles/LibraryTest.xlsx");

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        FileOutputStream fileOutputStream = new FileOutputStream("src/test/resources/excelFiles/LibraryTest.xlsx");

        Sheet sheet = workbook.createSheet("HelloWorld_03");

        Row row = sheet.createRow(3);

        Cell cell = row.createCell(4);

        cell.setCellValue("Mike Tyson");

        workbook.write(fileOutputStream);

        fileOutputStream.close();

        workbook.close();

        fileInputStream.close();
    }

}
