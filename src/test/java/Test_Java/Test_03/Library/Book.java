package Test_Java.Test_03.Library;

import java.util.HashMap;
import java.util.Map;

public class Book {

  static   String title;
  static   String author;
  static   Integer barcode;

    public static Map<Integer, Map<String, String>> booksCollection() {

        Map<Integer, Map<String, String>> result = new HashMap<Integer, Map<String, String>>();
        Map<String, String> booksInfo = new HashMap<>();
        booksInfo.put(title, author);
        result.put(barcode, booksInfo);
        return result;
    }
}
