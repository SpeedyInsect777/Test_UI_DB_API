package Test_Java.Test_01;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

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
    public void test05() {

        List<Integer> numList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            numList.add(faker.number().randomDigitNotZero());
        }
        System.out.println(numList);

        numList = numList.stream().map((x) -> {

            int result = 0;

            return x % 2 != 0 ? x % 2 : result;
        }).toList();
        System.out.println(numList);
    }

    @Test
    public void test06() {


        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nums.add(faker.number().randomDigitNotZero());
        }
        System.out.println(nums);
        List<Integer> finalNums = nums;
        nums = nums.stream().filter(x -> x % 2 == 0).map((x) -> {

            Integer result = 0;

            for (int i = 0; i < finalNums.size(); i++) {

                result += finalNums.get(i);
            }

            return result;
        }).toList();
        System.out.println(nums);
    }

    @DisplayName("Given a list of integers, " +
            "find the sum of all the even numbers")
    @Test
    public void test07() {

        List<Integer> sumOfNums = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            sumOfNums.add(faker.number().randomDigitNotZero());
        }
        System.out.println(sumOfNums);
        Integer resultList = sumOfNums.stream().filter(x -> x % 2 == 0).mapToInt(Integer::intValue).sum();
//We use the mapToInt() method to convert each even number to an int
        System.out.println(resultList);
    }

    @Test
    public void test08() {
        Function<List<Integer>, Integer> sumOfNums = (x) ->
        {
            Integer result = 0;
            for (int i = 0; i < x.size(); i++) {
                result += x.get(i);
            }
            return result;
        };
        List<Integer> numsAll = new ArrayList<Integer>(List.of(4, 6, 8, 9, 9, 7, 8, 7, 1, 1));
        System.out.println("Before: " + numsAll);
        System.out.println("After: " + sumOfNums.apply(numsAll));
    }

    @Test
    public void test09() {

        List<Integer> listNums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

        int total = listNums.stream().mapToInt(Integer::intValue).sum();

        System.out.println(total);

    }

    @Test
    public void test10() {

        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numberList.add(faker.number().randomDigit());
        }
        System.out.println(numberList);
        int total = numberList.stream().filter(x -> x > 0).mapToInt(Integer::intValue).sum();
        System.out.println(total);
    }

    @Test
    public void test11() {
        List<Long> numsLong = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numsLong.add(faker.number().randomNumber());
        }
        System.out.println(numsLong);
        int totals = numsLong.stream().filter(x -> x > 0).mapToInt(Long::intValue).sum();
        System.out.println(totals);
    }
@Test
    public void test12(){




}
}