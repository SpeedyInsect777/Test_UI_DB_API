package Test_Java.Test_01;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Test03 {

    Faker faker = new Faker();

    @Test
    public void test01() {

        List<String> myList = new ArrayList<>();

        myList.add(faker.name().firstName());
        myList.add(faker.name().firstName());
        myList.add(faker.name().firstName());

        Iterator<String> it = myList.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    @Test
    public void test02() {

        List<Character> charList = new ArrayList<>();
        System.out.println(charList.size());
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            charList.add('a');
            charList.add('f');
            charList.add('g');
        }
        System.out.println(charList.size());
        System.out.println("char: "+charList);
Iterator<Character> it = charList.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    @Test
    public void test03(){
        List<String> namesList = new ArrayList<>(Arrays.asList
                (faker.name().firstName(),faker.name().firstName()));
        Iterator<String> it  = namesList.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        namesList.stream().filter(x->x.startsWith("L")).forEach(System.out::println);
    }
}