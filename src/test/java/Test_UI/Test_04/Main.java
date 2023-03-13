package Test_UI.Test_04;

    class MyThread extends Thread {
        public void run() {
            // The code in this method will be executed in a separate thread
            System.out.println("Running in a new thread");
        }
    }

    public class Main {
        public static void main(String[] args) {
            MyThread myThread = new MyThread();
            myThread.start(); // This starts the new thread
        }
    }

