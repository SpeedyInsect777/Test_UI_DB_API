package Test_Java.Test_19;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test_04 {

    @Test
    void test01() {
        String strMatch = "VisitMatch!";
        Pattern pattern = Pattern.compile("(\\\\n|^).*?(?=\\\\n|$)");
        Matcher matcher = pattern.matcher(strMatch);
        if (matcher.find()) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }
    }

    @Test
    void test02() {
        String strMatch = "Visit" +
                "Match!";
        System.out.println(strMatch);
        Pattern pattern = Pattern.compile("\\n");
        Matcher matcher = pattern.matcher(strMatch);
        if (matcher.find()) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }
    }

    @Test
    public void test03() {
        int x = 0;
        if (x < 0) {
            System.out.println("Negative");
        } else if (x > 0) {
            System.out.println("Positive");
        } else {
            System.out.println("It's ZERO");
        }
    }

}

