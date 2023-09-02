package Test_Java.Test_00;

public class Main {

    public static void main(String[] args) throws ClassCastException {

        Parent parent = new Child();

        parent.parentMethod();

        Child child =   new Child();

        child.childMethod();

    }

        }
class Parent {

    public  void parentMethod(){
        System.out.println("Parent class/method running");
    }
}
class Child extends Parent{
    public void childMethod(){
        System.out.println("Child class/method running");
    }
}
