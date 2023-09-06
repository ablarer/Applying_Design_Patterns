import java.util.*;

//Cascade method pattern is sometimes also known as a train-wreck pattern

//Sometimes programmers get excited about this as builder but
//cascade method pattern is more general than builder. (do not confuse
//this with the Builder pattern).

class Mailer {
  public void from(String addr) { System.out.println("from..."); }
  public void to(String addr) { System.out.println("to..."); }
  public void subject(String line) { System.out.println("subject..."); }
  public void body(String message) { System.out.println("body..."); }
  public void send() { System.out.println("sending..."); }
}

public class Sample {
  public static void main(String[] args) {
    Mailer mailer = new Mailer();
    mailer.from("build@agiledeveloper.com");
    mailer.to("venkats@agiledeveloper.com");
    mailer.subject("Your code sucks");
    mailer.body("...detail...");
    mailer.send();
  }
}

/*
1. verbose
2. Should we reuse the mailer instance or should we not?

If it should be reused but we don't that is a waste of resource.
If it should not be reused but we do, that is bug.

But, that should not be a concern of the user of the abstraction, but
the creator of it.
*/
