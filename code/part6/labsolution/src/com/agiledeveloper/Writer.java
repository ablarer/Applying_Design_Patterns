package com.agiledeveloper;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

interface WriterConsumer<E extends Throwable> {
  void accept(Writer writer) throws E;
}

public class Writer {
  private FileWriter fileWriter;

  private Writer(String fileName) throws IOException {
    fileWriter = new FileWriter(fileName);
  }

  private void close() throws IOException {
    fileWriter.close();
  }

  public static void open(String fileName, WriterConsumer<IOException> block) throws IOException {
    Writer writer = new Writer(fileName);

    try {
      block.accept(writer);
    } finally {
      writer.close();
    }
  }

  public Writer write(String text) throws IOException {
    fileWriter.write(text);
    return this;
  }

  public static void main(String[] args) {
    try {
      Writer.open("output.txt", writer ->
          writer.write("This is line one\n")
                .write("This is line two\n")
                .write("This is yet another line"));

      System.out.println("The content of the file is:");

      java.nio.file.Files.readAllLines(Paths.get("output.txt"))
        .forEach(System.out::println);
    } catch(IOException ex) {
      System.out.println(ex.getMessage());
    }
  }
}
