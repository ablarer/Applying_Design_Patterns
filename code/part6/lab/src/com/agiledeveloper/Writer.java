package com.agiledeveloper;

import java.io.IOException;
import java.nio.file.Paths;

public class Writer {
  public static void main(String[] args) {
    try {
      //...open "output.txt"
      //.write("This is line one\n")
      //.write("This is line two\n")
      //.write("This is yet another line"));

      System.out.println("The content of the file is:");

      java.nio.file.Files.readAllLines(Paths.get("output.txt"))
        .forEach(System.out::println);
    } catch(IOException ex) {
      System.out.println(ex.getMessage());
    }
  }
}
