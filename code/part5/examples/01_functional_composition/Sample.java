import java.util.*;
import java.util.function.Function;

//Functional composition

public class Sample {
  public static void print(int number, String message,
    Function<Integer, Integer> func) {

    System.out.println(number + " " + message + ": " + func.apply(number));
  }

  public static void main(String[] args) {
    Function<Integer, Integer> inc = e -> e + 1;
    Function<Integer, Integer> doubled = e -> e * 2;

    print(5, "incremented", inc);
    print(5, "doubled", doubled);

    print(5, "incremented and doubled", inc.andThen(doubled));

    /*
      inc       -> | | ->
      doubled   -> | | ->


      --> || ---> |inc| ----> |doubled| ---> || -->
    */
  }
}

