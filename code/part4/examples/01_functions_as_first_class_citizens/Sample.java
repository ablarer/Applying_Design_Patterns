import java.util.*;

public class Sample {
  public static void main(String[] args) {
    //Thread th = new Thread(new Runnable() {
    //  public void run() {
    //    System.out.println("In another thread");
    //  }
    //});
    //We are passing an instance of an anonymous class of Runnable
    //to the constructor of Thread. Why?
    //Idiology of OO
    //We are allowed only to pass objects.
    //We treated functions like they are kindergarde children.
    //Can I go the park please? No, let me send an adult with you.

    Thread th = new Thread(() -> System.out.println("In another thread"));
    //We now treat functions as first class citizen

    //We can pass functions to functions rather than having to wrap them
    //into objects.

    th.start();

    System.out.println("In main thread");
  }
}

