package Test_Java.Test_09;

public class Test_02 extends Thread{

   private String lastName;

   public Test_02(String lastName){

       this.lastName=lastName;

   }
   public void run (){
       System.out.println("Lastname: "+lastName);
   }
}
