package Test_Java.Test_03.Library;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class Main {
    int num = 12;

    public static void main(String[] args) {

        Faker faker = new Faker();
        Book.barcode = faker.number().
                randomDigit();
        Book.title = faker.book().
                title();
        Book.author = faker.book().
                author();

        Main main = new Main();
        //   main.test01();
        main.test02();
    }

    public void test01() {

        num = 6546;

        System.out.println(Book.booksCollection());
        System.out.println(num);
    }

    public void test02() {

        System.out.println(Book.booksCollection());

        System.out.println(num);
    }
}