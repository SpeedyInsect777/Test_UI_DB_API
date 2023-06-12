package Test_Java.Test_00;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Test_01_BudgetExcelFileTest {

    FileInputStream fileInputStream = null;
    FileOutputStream fileOutputStream = null;
    Sheet sheet;
    Workbook workbook = null;

//Scanner scanner ;
  //  double totalMonthly;




            String path = "src/test/resources/excelFiles/BudgetExcelFileTest_01.xlsx";

    @Test
  //  @Ignore
    public void test01() {
        try {
            fileInputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(fileInputStream);

            sheet = workbook.getSheet("Manage My Money");
           //   sheet = workbook.getSheet("Sheet1");


Row row = sheet.createRow(3);
            System.out.println("Enter total Monthly Income: ");
        Scanner  scanner =  new Scanner(System.in);

          double  totalMonthly = scanner.nextDouble();

            row.createCell(2).setCellValue(totalMonthly);
            fileOutputStream = new FileOutputStream(path);
            workbook.write(fileOutputStream);

            System.out.println(sheet.getSheetName()+
                    "\nTotal monthly income: "+row.getCell(2) );


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (workbook != null) {
                    workbook.close();
                }
                if (fileOutputStream !=null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    String strTest="" ;
    @Test
    @Ignore
    public void test02(){
        System.out.println(strTest);
        strTest="Java";
        System.out.println(strTest);
    }
    @Test
    @Ignore
    public void test03(){
        System.out.println(strTest);
        strTest="World";
        System.out.println(strTest);
    }
}

