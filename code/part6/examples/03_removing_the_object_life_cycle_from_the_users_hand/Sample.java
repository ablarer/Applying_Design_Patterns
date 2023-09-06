import java.util.*;
import java.util.function.Consumer;

class Mailer {
  private Mailer() {}
  public Mailer from(String addr) { System.out.println("from..."); return this;}
  public Mailer to(String addr) { System.out.println("to..."); return this;}
  public Mailer subject(String line) { System.out.println("subject..."); return this;}
  public Mailer body(String message) { System.out.println("body..."); return this;}

  public static void send(Consumer<Mailer> block) { 
    Mailer mailer = new Mailer(); //here we can use a pool and reuse instances if we want to or throw away and use a new one. As the author of this class we can decide what is right or better.
    block.accept(mailer);
    System.out.println("sending..."); 
  }
}

public class Sample {
  public static void main(String[] args) {
    Mailer.send(mailer -> 
      mailer.from("build@agiledeveloper.com")
        .to("venkats@agiledeveloper.com")
        .subject("Your code sucks")
        .body("...detail..."));
  }
}

//We no longer have to worry about reuse or throw away of a Mailer instance
//since we are not really creating it.

