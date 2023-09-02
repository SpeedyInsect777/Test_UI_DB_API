package Test_Java.Test_11;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test_02 {

    @Test
    public void test01(){

        List <String> listNames = new ArrayList<>();

        listNames.add("John");
        listNames.add("Anna");
        listNames.add("Kim");

        Iterator<String> listIterator = listNames.iterator();

        while (listIterator.hasNext()){

            System.out.println(listIterator.next());

        }
    }
}
