import java.util.*;

public class Sample {
  public static void main(String[] args) {
    var numbers = List.of(1, 2, 3, 4, 5);

    //external iterator
    //for(var number: numbers) {
    //  if(number % 2 == 0) {
    //    System.out.println( number);
    //  }
    //}
    //the above is really
    var iterator = numbers.iterator();
    while(iterator.hasNext()) {
      var number = iterator.next();
      if(number % 2 == 0) {
        System.out.println(number);
      }
    }

    System.out.println(numbers.iterator());

    //external iterator is where we control the iteration step by step.
    //We break, continue, advance to the next element, etc.

    //internal iterator is where we focus on what to do for each element
    //and put the iteration on autopilot.

    numbers.stream()
      .filter(number -> number % 2 == 0)
      .forEach(System.out::println);

    //we can either get an Iterator<T> or a Stream<T> from a collection.
    //the first is an extenal iterator and the second is a internal iterator.


    //Both Iterator<T> and Stream<T> abstract out the iteration from a 
    //collection, eventhough they both do that differently.

    //Use of DIP. The code that iterates does not depend on Set, List, etc.
    //Instead, it depends on the abstraction of Iterator<T> or Stream<T>.
  }
}


/*
  Imagine 

  Sample ----> ArrayList  - tight coupling
  Sample ----> HashSet    - tight coupling


I want to iterate without carring about the type of data struture I am 
traversing.

One way to do this is

   Sample  ----->  Iterator where Iterator is implemented by ArrayList, HashSet, etc.

This becomes a text book example of DIP.

A class should not depend on a concreate class, instead both should
depend on an interface. In the above rather than Sample (concrete)
depending on HashSet (concrete) both will depend on Iterator which
is an interface.

But...

If they had done this, we will be in trouble while iterating.
Iteration needs a view. We can have concurrent iteration over a
data structure where one thread may be going from element 4 to 5
and another thread may be going from element 7 to 8.

So they went further to implement one more level of indirection.


Sample ---> Iterator  

                     ArrayList
		       internally implements an inner class that implements Iterator
		        iterator() { //factory method
			  return new Iterator<T>() {
			    ... a view into the ArrayList at hand ...
			  };
			}


Each time we call iterator() on an ArrayList we get a new instance of
the iterator that preserves the view for the clinet.
 
*/
