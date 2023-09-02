package Test_Excel.Test_01;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_01 {
    private String filePath = "src/test/resources/excelFiles/PrimeTest_01.csv";
    private String result;

        FileInputStream fileInputStream = null;
        Workbook workbook = null;
    @Test
    void Test01() {

        try {
            fileInputStream = new FileInputStream(filePath);
            workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheet("PrimeTest");
            Row row = sheet.getRow(1);
            Cell cell = row.getCell(0);
         //   cell
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
@Test
    public void test03(String filePath){

            String line;
            String csvSplitBy = ",";  // comma as separator, change if you have a different separator
    List<String> values = new ArrayList<>();

            try
                    (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                while ((line = br.readLine()) != null) {
                    // use comma as separator
                   String []  valuesArr = line.split(csvSplitBy);
values.addAll(Arrays.stream(valuesArr).toList());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    //System.out.println(values);
    System.out.println(values.get(0));
    System.out.println(values.get(1));

        }

        @Test
    public void test04(){}

    }




