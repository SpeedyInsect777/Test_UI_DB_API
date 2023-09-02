package Test_Java.Test_21;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Drivers driver1 = new Drivers("John Joe", 1, 100);
        System.out.println(driver1);

        driver1.setMilesDriven(500);
        System.out.println("=======");
        System.out.println(driver1);
        System.out.println(Drivers.getCount());

        Drivers driver2 = new Drivers("Steve Bob", 1, 100);
        System.out.println(Drivers.getCount());
        System.out.println(driver2);

   Set<Drivers> drivers = new HashSet<>();

   drivers.add(driver1);

    drivers.add(driver2);

        System.out.println(drivers.size());

    }


}
