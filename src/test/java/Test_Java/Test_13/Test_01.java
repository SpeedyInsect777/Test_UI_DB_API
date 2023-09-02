package Test_Java.Test_13;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Test_01 {


    @Test
    public void test01() {
        Library libraryOne = new Library();

        libraryOne.setAddress("123 Read st.");
        libraryOne.setName("Petro");
        libraryOne.setPhone(2111111L);
        libraryOne.setEmail("libraryOne@email.com");

        Map<Integer, Library> libraryMap = new HashMap<>();

        libraryMap.put(1, libraryOne);

        System.out.println(libraryMap.get(1));
    }

    @Test
    public void test02() {

        int libraryCard = 321;

        try {
            if (libraryCard != 123) {
                throw new Validation();
            }
        } catch (Validation e) {
            System.out.println(e.getMessage());
        }
    }

}


@Data
class Library {

    private String name;
    private String address;
    private Long phone;
    private String email;


}

class Validation extends Exception {
    public Validation() {
        super("Validation error");
    }
}