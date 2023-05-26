package Test_Java.Test_10;

import org.apache.logging.log4j.core.util.JsonUtils;

public class Test_03 {

    public static void main(String[] args) {

        ObjectOne one = new ObjectOne();
        ObjectTwo two = new ObjectTwo();
        ObjectThree three = new ObjectThree();
        one.run();
        two.run();
        three.run();

    }
}
class ObjectOne extends Thread{

    public void run(){
        System.out.println("RunOne");
    }
}
class ObjectTwo extends Thread{
    public void run(){
        System.out.println("RunTwo");
    }
}
class ObjectThree extends Thread{
    public void run(){
        System.out.println("RunThree");
    }
}
//print java hello world 10 times using 3 threads in java





