package Test_Java.Test01;

import com.github.javafaker.Faker;
import io.cucumber.java.bs.I;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;

public class Test01 {
    Faker faker = new Faker();

    @Test
    public void test01() {


        ArrayList<String> names = new ArrayList<>();
        names.add("John");
        names.add("Jane");
        names.add("Jim");

        Iterator<String> namesIterator = names.iterator();
        while (namesIterator.hasNext()) {
            String name = namesIterator.next();
            System.out.println(name);
        }

        Set<String> setStr = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            setStr.add(faker.name().firstName());
        }
        Iterator<String> iterator = setStr.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Set<String> stringSet = new HashSet<>();

        for (int i = 0; i < 5; i++) {
            setStr.add(faker.name().firstName());
        }
        Iterator<String> stringIterator = stringSet.iterator();

        while (stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
        }
    }

    @Test
    public void test02() {

        Integer numInteger = 23;

        Function<Integer, Integer> nums = (x) ->

        {
            Integer result = 0;

            result = x * 2;

            return result;
        };
        List<Integer> listNum = new ArrayList<>();

        System.out.println(nums.apply(numInteger));

    }

    @Test
    public void test03() {

        Set<String> setStr = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            setStr.add(faker.name().firstName());
        }
        Function<Set<String>, Integer> functionStr = (x) ->
        {
            Integer count = 0;
            if (!x.isEmpty()) {
                count++;
            }
            return count;
        };

        System.out.println(functionStr.apply(setStr));
    }

    @Test
    public void test04() {

        Set<String> setStr = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            setStr.add(faker.name().firstName());
        }
        System.out.println(setStr);
    }
    @Test
    public void test05(){



    }
}