import java.util.*;

abstract class Writer {
  private boolean open = true;
  private Writer next;

  protected Writer() {}
  public Writer(Writer next) { this.next = next; }

  public final void write(String text) {
    if(open) {
      writeContent(text);
    }
  }

  protected abstract void writeContent(String text);

  public String getContents() {
    return next.getContents();
  }

  protected Writer getNext() { return next; }

  public void close() { open = false; }
}

class StringWriter extends Writer {
  private StringBuilder content = new StringBuilder();

  protected void writeContent(String text) {
    content.append(text);
  }

  public String getContents() {
    return content.toString();
  }
}

class LowerCaseWriter extends Writer {
  public LowerCaseWriter(Writer next) { super(next); }

  public void writeContent(String text) {
    getNext().write(text.toLowerCase());
  }
}

class UpperCaseWriter extends Writer {
  public UpperCaseWriter(Writer next) { super(next); }

  public void writeContent(String text) {
    getNext().write(text.toUpperCase());
  }
}

class StupidRemover extends Writer {
  public StupidRemover(Writer next) { super(next); }

  public void writeContent(String text) {
    getNext().write(text.replaceAll("stupid", "s*****"));
  }
}


public class Sample {
  public static void useWriter(Writer writer) {
    writer.write("This is a stupid test");
    System.out.println(writer.getContents());
  }

  public static void main(String[] args) {
    useWriter(new StringWriter());
    //useWriter(new FileWriter());
    //useWriter(new SocketWriter());

    useWriter(new LowerCaseWriter(new StringWriter()));
    useWriter(new UpperCaseWriter(new StringWriter()));
    useWriter(new StupidRemover(new StringWriter()));
    useWriter(new LowerCaseWriter(new StupidRemover(new StringWriter())));
    useWriter(new UpperCaseWriter(new StupidRemover(new StringWriter())));
  }
}
