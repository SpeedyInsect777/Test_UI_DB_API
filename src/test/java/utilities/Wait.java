package utilities;

public class Wait {

    public static void wait(int sec) {

        try {
            Thread.sleep(sec * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
