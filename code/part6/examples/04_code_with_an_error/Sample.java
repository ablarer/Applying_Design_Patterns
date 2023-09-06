import java.util.*;

class Resource {
  public Resource() { System.out.println("allocate external resource"); }
  public Resource op1() {
    System.out.println("op1...");
    return this;
  }
  public Resource op2() {
    System.out.println("op2...");
    return this;
  }
  public void finalize() {
    System.out.println("clean up the external resource");
  }
}

public class Sample {
  public static void use() {
    Resource resource = new Resource();
    resource.op1();
    resource.op2();
    //The GC is automatic but non-deterministic
    //It may never be called if there is a lot of memory
  }

  public static void main(String[] args) {
    use();
  }
}

