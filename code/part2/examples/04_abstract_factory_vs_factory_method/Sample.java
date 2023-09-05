import java.util.*;

public class Sample {
  public static void main(String[] args) {
  }
}

/*
Abstract Factory

uses delegation as the primary design tool
Family of products
consistency amoung the products
varations in the memory types are hard

Factory method
uses inheritance as the primary design tool
A class relies on its derived classes to vary the type of the members.

Abstract Factory needs more code or needs a library or a framework
Factory method needs less code but increases coupling between the 
concreate Computer (for example) and one of its concreate devices like Memory.
Factory method does not insist on consistency between the products.

If it makes sense for an object to self-configure, then factory method is a good choice. Otherwise, don't rely on factory method.

Factory method vs. factory class (aka abstract factory [class])

There is more compuling between the classes in Factory Method whereas
that is separated into Factory classes in the case of Abstract factory.
*/


