package Test_Java.Test_01;

import java.util.Scanner;

public class Test05 {
    public static void main(String[] args) {

        Scanner scanner =  new Scanner(System.in);

        String str = scanner.next();

        try{
            if (str.equalsIgnoreCase("Mike")){
                System.out.println("Verified");
            }else {
                throw new Verified();
            }
        }catch (Verified e){
            System.out.println(e);
        }
    }
}
class Verified extends Exception{
    Verified(){
        super("Verification failed");
    }
}