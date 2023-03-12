package Test_UI.Test_03;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test_02 {
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;
    Workbook workbook;
    Sheet sheet;
    Sheet createSheet;
    Row row;
    Row createRow;
    Cell cell;
    Cell createCell;
    @BeforeEach
    public void setWorkbook() throws IOException {

        fileInputStream = new FileInputStream("src/test/resources/excelFiles/LibraryTest.xlsx");
        workbook = WorkbookFactory.create(fileInputStream);

        sheet = workbook.getSheet("HelloWorld");

    }
    @AfterEach
    public void quitWorkbook() throws IOException {

        workbook.close();

       // fileInputStream.close();

    }
    @Test
    public void test01() throws IOException {

        row = sheet.getRow(1);

        cell = row.getCell(2);

        System.out.println(cell.getStringCellValue());

    }

    @Test
    public void test02() throws IOException {

        fileOutputStream = new FileOutputStream("src/test/resources/excelFiles/LibraryTest.xlsx");

        createSheet = workbook.createSheet("HelloWorld_01");

        createRow = createSheet.createRow(3);

        createCell = createRow.createCell(4);

        createCell.setCellValue("Mike Tyson");

        workbook.write(fileOutputStream);

        fileOutputStream.close();
    }
}
