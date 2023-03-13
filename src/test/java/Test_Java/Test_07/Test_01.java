package Test_Java.Test_07;


public class Test_01 {
    public static void main(String[] args) {

        int age = 20;

        try {
            if (age < 18) {
                throw new AgeException();
            }
        } catch (Throwable e) {
            System.out.println(e);
        }finally {
            System.out.println("Your age: "+age);
        }
    }
    }
  class AgeException extends Exception{
        public AgeException (){
            super("Access DENIED");
        }
  }

