import java.util.*;

class Mailer {
  public Mailer from(String addr) { System.out.println("from..."); return this;}
  public Mailer to(String addr) { System.out.println("to..."); return this;}
  public Mailer subject(String line) { System.out.println("subject..."); return this;}
  public Mailer body(String message) { System.out.println("body..."); return this;}
  public void send() { System.out.println("sending..."); }
}

public class Sample {
  public static void main(String[] args) {
    Mailer mailer = new Mailer();
    mailer.from("build@agiledeveloper.com")
      .to("venkats@agiledeveloper.com")
      .subject("Your code sucks")
      .body("...detail...")
      .send();
    //the cascade method pattern
  }
}

//Less verbose
//But we still have the problem of reuse or use and throw of the new Mailer

//We are leaning on creating a DSL

//We can impose ordering and such by having different interfaces, for 
//example, like MailReady which provides a send and body returns that
//interface.

