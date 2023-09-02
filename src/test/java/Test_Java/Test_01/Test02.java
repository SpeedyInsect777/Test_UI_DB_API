package Test_Java.Test_01;

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int age = scan.nextInt();

        try{
            if(age<18){
                throw new AgeException();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
class AgeException extends Exception{

    public AgeException(){

        super("Access DENIED");

    }
}