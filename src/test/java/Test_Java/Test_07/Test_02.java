package Test_Java.Test_07;

public class Test_02 {

    public static void main(String[] args) {

        String str = "Java!";

        try {
            if (!str.equalsIgnoreCase("Java")) {
                throw new CustomException();
            }
        } catch (Throwable e) {
            System.out.println(e);
        } finally {
            System.out.println("Finally running...");
        }
    }
}
class CustomException extends Throwable{
        public CustomException(){
            super("Exception occurred");
        }
}

