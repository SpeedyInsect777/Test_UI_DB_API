package Test_PDF.Test_01;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test_01 {

    public static int  newlineFinder (String text){
int result = 0;
        if (text.contains("\n")) {
            result=+1;
        }
        return result;
    }

        public static void main(String[] args) {

            String text = "";

            try {
                // Load the PDF document
                File file = new File("src/test/resources/pdfFiles/Prime_Motor_Carrier_Inc_Report.pdf");
                PDDocument document = PDDocument.load(file);

                // Instantiate the PDFTextStripper class
                PDFTextStripper pdfStripper = new PDFTextStripper();

                // Retrieve text from the PDF
                text = pdfStripper.getText(document);


                // Print the extracted text

                // Close the document
                document.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(text);

            Pattern pattern = Pattern.compile("\\n");
            Matcher matcher = pattern.matcher(text);

            int newLines= 0;

            while (matcher.find()){
                newLines++;
            }
            System.out.println("Number of New Lines: "+newLines);


            String hhh = "";
        }


    }

