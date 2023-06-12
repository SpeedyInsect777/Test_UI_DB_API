package Test_Java.Test_09;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test_01 {

    FileInputStream fileInputStream = null;
    FileOutputStream fileOutputStream = null;
    Workbook workbook = null;
    Sheet sheet = null;

    @Test
    public void test01() {

        int input = 12;

        String excelFilePath = "excelFiles/BudgetExcelFileTest_01.xlsx";

        try {
            fileInputStream = new FileInputStream(excelFilePath);
            workbook = WorkbookFactory.create(fileInputStream);
            sheet = workbook.getSheet("Manage My Money");
            Row row = sheet.getRow(4);
            row.createCell(2).setCellValue(input);

            fileOutputStream = new FileOutputStream(excelFilePath);
            workbook.write(fileOutputStream);

        } catch (IOException e) {

        } finally {

        }
    }
}
