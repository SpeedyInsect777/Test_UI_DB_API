package Test_UI.Test_05;
import java.io.*;
class ReadDataThread extends Thread {
    private String fileName;

    public ReadDataThread(String fileName) {
        this.fileName = fileName;
    }

    public void run() {
        System.out.println("Reading data from file: " + fileName);
        try {
            // Read data from file
            // ...
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ProcessDataThread extends Thread {
    public void run() {
        System.out.println("Processing data");
        try {
            // Process the data
            // ...
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class WriteDataThread extends Thread {
    private String fileName;

    public WriteDataThread(String fileName) {
        this.fileName = fileName;
    }

    public void run() {
        System.out.println("Writing data to file: " + fileName);
        try {
            // Write the processed data to another file
            // ...
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ReadDataThread readDataThread = new ReadDataThread("input.txt");
        ProcessDataThread processDataThread = new ProcessDataThread();
        WriteDataThread writeDataThread = new WriteDataThread("output.txt");

        readDataThread.start();
        processDataThread.start();
        writeDataThread.start();
    }
}

