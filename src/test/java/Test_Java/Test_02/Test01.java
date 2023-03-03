package Test_Java.Test_02;


import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.function.Function;

public class Test01 {

    String name;
    String lastName;

    @ParameterizedTest(name = "{index} number is {0}")

    @ValueSource
            (
                    ints = {5, 7, 8, 5, 9}
            )
    public void test02(int nums) {

        System.out.println(nums);

    }

    @ParameterizedTest(name = "{index}, name is {0}")
    @CsvSource({"Mike, Tyson", "Joe, Rogan"})
    public void test03(String names, String lastNames) {
        System.out.println(names + " " + lastNames);

    }

    @ParameterizedTest(name = "{index}, name is {0}")
    @CsvSource({"Mikeke, Tonyson", "Joeor, Roganoa"})
    public void test04(String names, String lastNames) {
        //  System.out.println(names+" "+lastNames);
        System.out.println("name: " + names);
        System.out.println("lastname: " + lastNames);

        name = names;

        lastName = lastNames;

        System.out.println("name: " + name);
        System.out.println("lastname: " + lastName);

    }

    @Test
    public void myTest() {

        String str = "java";

        String result = "";

        for (int i = 0; i <= str.length() - 1; i++) {

            int count = 0;

            for (int k = 0; k <= str.length() - 1; k++) {

                if (str.charAt(i) == str.charAt(k)) {

                    count++;

                }
            }
            result+="|"+count+str.charAt(i);
        }
        System.out.println(result);
    }
}
