import java.util.*;
import java.util.function.Consumer;

class Resource {
  private Resource() { System.out.println("allocate external resource"); }
  public Resource op1() {
    System.out.println("op1...");
    return this;
  }
  public Resource op2() {
    System.out.println("op2...");
    return this;
  }
  private void close() {
    System.out.println("clean up the external resource");
  }

  public static void use(Consumer<Resource> block) {
    Resource resource = new Resource(); //Before advice

    try{
      block.accept(resource); //middle of the code, logic that is executed by the caller
    } finally {
      resource.close(); //After advice
    }
  }
}

public class Sample {
  public static void compute() {
    Resource.use(resource -> 
      resource.op1()
        .op2());
    //Before we get into the body of code, we have a pre-op
    //After we finish the body of code, we have a post-op
  }

  public static void main(String[] args) {
    compute();
  }
}

/*
You want to run a piece of code, but around it, that is before and after
you want to run some code.

AOP

*/
