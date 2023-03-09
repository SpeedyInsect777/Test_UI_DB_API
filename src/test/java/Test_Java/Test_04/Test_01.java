package Test_Java.Test_04;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test_01 {

    @Test
    public void test01() {

   Map<String,String> myMap = new HashMap<>();

   myMap.put("a","candy");
   myMap.put("b","dirt");



    }
    @Test
    public void test02() {
        try {
            FileInputStream file = new FileInputStream(new File("src/test/resources/MyExcel/Library.xlsx"));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + " ");
                            break;
                        case STRING:
                            System.out.print(cell.getStringCellValue() + " ");
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + " ");
                            break;
                        default:
                            System.out.print("Unknown cell type");
                    }
                }
                System.out.println();
            }
            workbook.close();
            file.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IO exception: " + e.getMessage());
        }
    }

}

