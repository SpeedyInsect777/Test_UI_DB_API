package Test_Java.Test_09;

import org.junit.jupiter.api.Test;

public class Test_02 {


    @Test
    public void test01(){

        String word = "Word2";

try {
    if (!word.equalsIgnoreCase("Word")){
throw new FailedTest();
    }
}
catch (Throwable e){
    System.out.println(e);
}
    }
}
class FailedTest extends Throwable {

    public FailedTest() {

    super("Test Failed");
}
}
