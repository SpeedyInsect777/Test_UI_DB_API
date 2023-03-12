package Test_Java.Test_04;
import org.junit.jupiter.api.Test;

public class Test_02 {
    @Test
    public void test01(){
        String str = "HelloWorld";

        for(int i = 0 ; i < str.length(); i++){

            System.out.println("i=======> "+i);

            for (int j = 0; j < str.length(); j++) {

                System.out.println("j=> "+j);

            }
        }
    }
}





