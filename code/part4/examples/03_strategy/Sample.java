import java.util.*;
import java.util.function.IntPredicate;

/*
In the past, to implement the Strategy pattern we often created
an interface, a bunch of implementation classes. We delegated
from our algorithm to an implementation via a reference to the interface.
These implementation classes where mostly single method implementation
classes. That was quite heavy weight.

But now, in a number of languages we can pass functions around.

A strategy is simply a function that corresponds to a signature that
is expected.
*/

public class Sample {
  public static int totalNumbers(List<Integer> numbers, 
    IntPredicate selector) { //selector is a strategy
    int result = 0;

    for(var number: numbers) {
      if(selector.test(number)) {
        result += number;
      }
    }

    return result;
  }

  public static boolean isOdd(int number) {
    return number % 2 != 0;
  }

  public static void main(String[] args) {
    var numbers = List.of(1, 2, 3, 4, 5, 6);

    System.out.println(totalNumbers(numbers, e -> true));

    System.out.println(totalNumbers(numbers, e -> e % 2 == 0));

    System.out.println(totalNumbers(numbers, Sample::isOdd));
  }
}

// Lambdas are lightweight strategies.

