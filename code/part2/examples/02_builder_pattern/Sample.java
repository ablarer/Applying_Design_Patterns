import java.util.*;

abstract class Base {}
class WheetBase extends Base {}
abstract class Sauce {}
class TomatoSauce extends Sauce {}
abstract class Topping {}
class Onion extends Topping {}
class Olives extends Topping {}
class Peppers extends Topping {}
abstract class Cheese {}
class AmericanCheese extends Cheese {}
class Mozzarella extends Cheese {}

class Pizza {
  private Base base; 
  private Sauce sauce; 
  private Cheese cheeseLayer; 
  private Cheese topLayer; 
  private List<Topping> toppings = new ArrayList<>(); 

  public void setBase(Base base) { this.base = base; }
  public void setSauce(Sauce sauce) { this.sauce = sauce; }
  public void setCheeseLayer(Cheese cheese) { this.cheeseLayer = cheese; }
  public void setTopLayerCheese(Cheese cheese) { this.topLayer = cheese; }
  public void addTopping(Topping topping) { toppings.add(topping); }

  public String toString() {
    return base.getClass().getSimpleName() + " : " + 
      sauce.getClass().getSimpleName() + " : " +
      cheeseLayer.getClass().getSimpleName() + " : " +
      toppings + " : " +
      topLayer.getClass().getSimpleName();

  }
}

abstract class PizzaMaker {
  public final Pizza makePizza() {
    Pizza pizza = new Pizza();

    pizza.setBase(createBase());
    pizza.setSauce(createSauce());
    pizza.setCheeseLayer(createBaseCheese());
    addToppings(pizza);
    pizza.setTopLayerCheese(createTopCheese());

    return pizza;
  }

  public abstract Base createBase();
  public abstract Sauce createSauce();
  public abstract Cheese createBaseCheese();
  public abstract void addToppings(Pizza pizza);
  public abstract Cheese createTopCheese();
}

class CheesePizzaMaker extends PizzaMaker {
  public Base createBase() { return new WheetBase(); }
  public Sauce createSauce() { return new TomatoSauce(); }
  public Cheese createBaseCheese() { return new Mozzarella(); }
  public void addToppings(Pizza pizza) {}
  public Cheese createTopCheese() { return new AmericanCheese(); }
}

class VeggieLoversMaker extends PizzaMaker {
  public Base createBase() { return new WheetBase(); }
  public Sauce createSauce() { return new TomatoSauce(); }
  public Cheese createBaseCheese() { return new Mozzarella(); }
  public void addToppings(Pizza pizza) {
    pizza.addTopping(new Onion());
    pizza.addTopping(new Olives());
    pizza.addTopping(new Peppers());
  }
  public Cheese createTopCheese() { return new AmericanCheese(); }
}

public class Sample {
  public static void main(String[] args) {
    Pizza pizza = new CheesePizzaMaker().makePizza();  
    System.out.println(pizza);

    System.out.println(new VeggieLoversMaker().makePizza());
  }
}

//Different pizza instances may have different ingrediants (parts).
//We are consistent here on the process of making or building and not
//on the parts that make the whole.

//Abstract Factory keeps the parts consistent, not the creation steps.
//Builder keeps the creationg steps or process consistent, not the parts.

