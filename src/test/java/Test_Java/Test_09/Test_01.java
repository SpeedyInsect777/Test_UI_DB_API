package Test_Java.Test_09;

public class Test_01 extends Thread {

    private String name;

    public Test_01(String name){
        this.name=name;
    }

    public void run (){

        System.out.println("Name: "+name);

    }
}
