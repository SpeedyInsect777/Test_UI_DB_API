package Test_Java.Test_11;

import org.junit.jupiter.api.Test;

public class Test_01 {
    @Test
    public void test_01() {

        int[] arr = {2, 7, 11, 15};

        int target = 9;

        for (int k = 0; k < arr.length; k++) {

            for (int i = 0; i < arr.length; i++) {

                if (arr[k] + arr[i] == target) {
                    System.out.println("bingo");
                }
            }
        }
    }
    @Test
    public void test_02(){
        char arrChar[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n'};

        

for (int i = 0; i < arrChar.length; i++) {
            System.out.println(arrChar[i]);
        }

    }
}