import java.util.*;

public class Sample {
  public static void main(String[] args) {
  }
}

/*
Decorator is used to enhance the capabilities of an object.

new BufferedInputStream(
  new DataInputStream(
    new FileInputStream("....")));

We take a core object and add flavors of behavior to it.

When it comes to Strategy, we want to focus on an algorithm but
we want to replace a little part of its internals with alternative
implementations.

class Algorithm {
  Strategy someStrategy;

  public void computation(input...) {
    ... the core of the functionality ...
    var someValue = someStrategy.get();
    ... use someValue ...
    ... the core of the functionality ...
  }
}

You may run Algorithm with SomeStrategy1, or SomeStrategy2, etc.

The structure is somewhat similar between decorator and strategy

How are they different?

Strategy allows us to vary the guts whereas decorator allows to vary the skin




*/
