package Test_Java.Test_01;

import java.util.Scanner;

public class Test04 {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        String strPassword = scan.next();

        try {
            if (strPassword.equalsIgnoreCase("Mike")) {
                System.out.println("Access granted");
            } else {
                throw new CustomError();
            }
        } catch (CustomError e) {
            System.out.println(e);
        }
    }
}
class CustomError extends Exception{
    public CustomError(){
        super("Error occurred");
    }
}