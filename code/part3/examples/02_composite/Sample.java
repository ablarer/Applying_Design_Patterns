import java.util.*;

public class Sample {
  public static void main(String[] args) {
  }
}

/*
Composite pattern is useful when we want to treat an object and a collection
of objects uniformly and consistenly.

This pattern is interesting because it is intended to honor LSP but in the
end fails that very principle. Why?

For a collection and a single object to be treated uniformly we will have
to pull up the methods needed for the collection to the base class. Which
in turn means that the single object will support as no ops or throw 
exception if any of the methods intended for the collection is called
on the single object.

Leads to overgeneralization of the methods of the base class and useless
implementation of methods in the single object.

class FlipFlow implements Gate {}

To provide uniformity

interface Gate {
  ...
  void addGate(Gate gate);
  void remove(..., Gate gate);
}



           *
    Base <---------------------
      ^                       |
      _                       |
      |                       |
      |                       |
      |                       |
  Component    Composite <>---|
*/
