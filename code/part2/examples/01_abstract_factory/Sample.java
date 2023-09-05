import java.util.*;

/*
We have a *family* of products that come together to create a product.
We want be *consistent* with the top level product where we want every
product to have each of the items that makes up the whole.

Our goal is to create a product, one among a few.

If I am making a computer, order may not imporant of how the parts are put together - Abstract Factory.
If I am making a computer, order may is imporant of how the parts are put together - Builder. (for instance, there is an order in how we make different Pizzas)

Suppose we have different models of computers. Each computer is required
to have a Monitor, Momory, Disk. But, we want to assemble models with
the approriate types of parts for each model.
*/

abstract class Monitor {}
class MonitorA extends Monitor {}
class MonitorB extends Monitor {}
class MonitorC extends Monitor {}

abstract class Memory {}
class MemoryA extends Memory {}
class MemoryB extends Memory {}
class MemoryC extends Memory {}

abstract class Disk {}
class DiskA extends Disk {}
class DiskB extends Disk {}

abstract class Computer {
  private Memory memory;
  private Monitor monitor;
  private Disk disk;

  public void setMemory(Memory memory) { this.memory = memory; }
  public void setMonitor(Monitor monitor) { this.monitor = monitor; }
  public void setDisk(Disk disk) { this.disk = disk; }

  public String toString() {
    return getClass().getSimpleName() + ": " +
      memory.getClass().getSimpleName() + ": " +
      monitor.getClass().getSimpleName() + ": " +
      disk.getClass().getSimpleName();
  }
}

class ComputerA extends Computer {}
class ComputerB extends Computer {}
class ComputerC extends Computer {}

public class Sample {
  public static Computer createComputerPoorDesign(String model) {
    Computer computer = null;

    if(model.equals("A")) {
      computer = new ComputerA();
      computer.setMemory(new MemoryA());
      computer.setMonitor(new MonitorA());
      computer.setDisk(new DiskA());
    }

    if(model.equals("B")) {
      computer = new ComputerB();
      computer.setMemory(new MemoryB());
      computer.setMonitor(new MonitorB());
      computer.setDisk(new DiskB());
    }

    if(model.equals("C")) {
      computer = new ComputerC();
      computer.setMemory(new MemoryC());
      computer.setMonitor(new MonitorC());
      computer.setDisk(new DiskB());
    }

    return computer;
    //This code has a few design smells in it:
    //We are violating the OCP - the code is not extensible for new models
    //we are also violating DRY
  }

  public static void main(String[] args) {
    System.out.println(createComputerPoorDesign("A"));
    System.out.println(createComputerPoorDesign("B"));
    System.out.println(createComputerPoorDesign("C"));

    System.out.println("---------");
    System.out.println(createComputer(new ComputerFactoryA()));
    System.out.println(createComputer(new ComputerFactoryB()));
    System.out.println(createComputer(new ComputerFactoryC()));
  }

  public static Computer createComputer(ComputerFactory factory) {
    Computer computer = factory.create();
    computer.setMemory(factory.createMemory());
    computer.setMonitor(factory.createMonitor());
    computer.setDisk(factory.createDisk());

    return computer;

    /*
    The parts may be created in any order as the createComputer() pleases
    The factory can't enforce that.
    Memory memory = factory.createMemory();
    ...
    Computer computer = factory.create();
    computer.setMemory(memory);
    ...

    return computer;
    */

    //is concise, does not vilate OCP or DRY. If we add a new model of
    //computer this function does not have to change.
  }
}

interface ComputerFactory {
  Computer create();
  Memory createMemory();
  Monitor createMonitor();
  Disk createDisk();
}

class ComputerFactoryA implements ComputerFactory {
  public Computer create() { return new ComputerA(); }
  public Memory createMemory() { return new MemoryA(); }
  public Monitor createMonitor() { return new MonitorA(); }
  public Disk createDisk() { return new DiskA(); }
}

class ComputerFactoryB implements ComputerFactory {
  public Computer create() { return new ComputerB(); }
  public Memory createMemory() { return new MemoryB(); }
  public Monitor createMonitor() { return new MonitorB(); }
  public Disk createDisk() { return new DiskB(); }
}

class ComputerFactoryC implements ComputerFactory {
  public Computer create() { return new ComputerC(); }
  public Memory createMemory() { return new MemoryC(); }
  public Monitor createMonitor() { return new MonitorC(); }
  public Disk createDisk() { return new DiskB(); }
}

//Think about the *family* of products with *consistent* parts that make
//each product. The order of creation is not important. This is a place
//where we can use Abstract Factory.


