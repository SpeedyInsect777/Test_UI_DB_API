package utilities;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelToolBox {

    private String filePath;
    private String sheetName;

    public ExcelToolBox(String filePath, String sheetName) {
        this.filePath = filePath;
        this.sheetName = sheetName;
    }

    public String getExcelData(int rowNumber, int cellNumber) {
        try (FileInputStream fileInputStream = new FileInputStream(this.filePath);
             Workbook workbook = WorkbookFactory.create(fileInputStream)) {

            Sheet sheet = workbook.getSheet(this.sheetName);
            Row row = sheet.getRow(rowNumber);
            Cell cell = row.getCell(cellNumber);
            return cell.getStringCellValue();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void setExcelData(int rowNumber, int cellNumber, String value) {
        Workbook workbook = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(this.filePath);
            workbook = WorkbookFactory.create(fileInputStream);

            Sheet sheet = workbook.getSheet(this.sheetName);
            Row row = sheet.getRow(rowNumber);
            if (row == null) {
                row = sheet.createRow(rowNumber);
            }
            Cell cell = row.getCell(cellNumber);
            if (cell == null) {
                cell = row.createCell(cellNumber);
            }
            cell.setCellValue(value);

            fileInputStream.close();  // Close the FileInputStream

            try (FileOutputStream fileOutputStream = new FileOutputStream(this.filePath)) {
                workbook.write(fileOutputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();  // Ensure the workbook gets closed
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();  // Ensure the FileInputStream gets closed
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}


