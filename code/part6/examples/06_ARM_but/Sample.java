import java.util.*;

//Java 7 introduce the ARM: Automatic Resource Management

class Resource implements AutoCloseable {
  public Resource() { System.out.println("allocate external resource"); }
  public Resource op1() {
    System.out.println("op1...");
    return this;
  }
  public Resource op2() {
    System.out.println("op2...");
    return this;
  }
  public void close() {
    System.out.println("clean up the external resource");
  }
}

public class Sample {
  public static void use() {
    try(Resource resource = new Resource()) {
      resource.op1();
      resource.op2();
    } //automatically calls close
  }

  public static void main(String[] args) {
    use();
  }
}

/*
In life and programming we solve a set of problems only to find
that we have created a new set of problems.
*/

//That looks really cool, but
//if we forgot to put try will the compiler give us an error: No
//if we forgot to put try will the compiler give us a warning: No

//That is quite sad. We can now blame the programmers who forgot
//to add it. Not a good solution.

//ARM is not that great. So, what gives.

