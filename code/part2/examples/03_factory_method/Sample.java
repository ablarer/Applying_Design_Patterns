import java.util.*;

/*
Suppose we have a different models of computers, like in the abstract factory
Each computer is required to have a Monitor, Memory, Disk, etc.
But, we want to assemble models with different parts in it based on the model.
We want to design in a way that a computer can self-configure based on the 
model.
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

  public void configure() {
    memory = createMemory();
    monitor = createMonitor();
    disk = createDisk();
  }

  abstract protected Memory createMemory();
  abstract protected Monitor createMonitor();
  abstract protected Disk createDisk();

  public String toString() {
    return getClass().getSimpleName() + ": " +
      memory.getClass().getSimpleName() + ": " +
      monitor.getClass().getSimpleName() + ": " +
      disk.getClass().getSimpleName();
  }
}

class ComputerA extends Computer {
  protected Memory createMemory() { return new MemoryA(); }
  protected Monitor createMonitor() { return new MonitorA(); }
  protected Disk createDisk() { return new DiskA(); }
}

class ComputerB extends Computer {
  protected Memory createMemory() { return new MemoryB(); }
  protected Monitor createMonitor() { return new MonitorB(); }
  protected Disk createDisk() { return new DiskB(); }
}

class ComputerC extends Computer {
  protected Memory createMemory() { return new MemoryC(); }
  protected Monitor createMonitor() { return new MonitorC(); }
  protected Disk createDisk() { return new DiskB(); }
}

public class Sample {
  public static Computer configureComputer(Computer computer) {
    computer.configure();
    return computer;
  }

  public static void main(String[] args) {
    System.out.println(configureComputer(new ComputerA()));
    System.out.println(configureComputer(new ComputerB()));
    System.out.println(configureComputer(new ComputerC()));
  }
}

//In this case, a class is letting a subclass decide the parts to use.
//We are not using a factory class (abstract factory) instead we are using
//a factory method (Factory Method). A class rely on its subclass to
//abstract out the details of the instances to use.

//Where as the client in Abstract Factory was using a Factory object to
//delegate the responsibility (object scope), in this case, the client
//uses a subclass to decide on instance (inheritance is the main design tool
//- class scope).


