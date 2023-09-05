import java.util.*;

/*
Bridge vs. Adaptor

We are using Bridge as a forethought and we often use an Adaptor as an
afterthought.

Adaptor are usefull when the interfaces of what we have are not compatible
with the interfaces of what we want to integrate.

Keep in mind that the implementation needs to be compatible.

*/

interface Gate {
  public default void set(int position, boolean value) {
    System.out.println("set and trigger evaluation of the gate");
  }
}

class AndGate implements Gate {
  public void set(int position, boolean value) {
    System.out.println("set and trigger evaluation of the gate");
  }
}

class ORGate implements Gate {
  public void set(int position, boolean value) {
    System.out.println("set and trigger evaluation of the gate");
  }
}

public class Sample {
  public static void useGate(Gate gate) {
    gate.set(0, true);
    gate.set(1, false);
  }

  public static void main(String[] args) {
    useGate(new AndGate());
    useGate(new ORGate());

    useGate(new EXORGateAdaptor1());
    useGate(new EXORGateAdaptor2(new EXORGate()));
  }
}

//suppose later on we are give a third party library with the following:

class EXORGate {
  public void setValue(int position, boolean value) {
    System.out.println("setValue called...");
  }

  public void trigger() {
    System.out.println("triggering...");
  }
}

//and we are asked to use this EXORGate in our application. How do we
//apporach that? [We obviously can't change the EXORGate].

//Adaptor pattern comes in two flavors, both as class based (Inheritance)
//and Object based (Delegation).

class EXORGateAdaptor1 extends EXORGate implements Gate {
  public void set(int position, boolean value) {
    setValue(position, value);
    trigger();
  }

  //you may override the setValue and/or trigger here if you like
}

class EXORGateAdaptor2 implements Gate {
  private EXORGate gate;

  public EXORGateAdaptor2(EXORGate gate) {
   this.gate = gate;
  }

  public void set(int position, boolean value) {
    gate.setValue(position, value);
    gate.trigger();
  }
}

//Which one is better?

//It depends...

//The class adapter is able to extend the class it is adapting as well.
//So we can customize the class we are adapting while we are adapting.
//We use only one object for adapting rather that one for adapting and
//one for the adapted. Kind of memory usage.

//The object adapter is able to adapt a class and all of its subclasses.
//We are adapting a hierarchy of classes instead of one class.
//We use one extra object for the adaptor in addition to an instance of
//the class being adapted. More DRY than class adapter for adapting a
//hierarcy of classes.





