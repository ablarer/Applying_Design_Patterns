/*
We may want to restrict the number of instances of a class to one (or a 
handfull).

class DBManager {
  private static DBManager instance;
  private DBManager() {}

  public static DBManager create() {
    if(instance == null) {
      instance = new DBManager();
    }

    return instance;
  }
}
*/

//A very simple pattern.
//But, a few concerns.
//1. If we only want a single instance, then why not create a class or an 
//interface with only static method and be done with it, why bother with a 
//class and limit instances of it?
//In fact there are no instance if we go the static route.
//
//That sure is a good approach if we don't want to every extend the functions
//of a singleton with altenative implementations. If we want variations
//of a singleton, then we may use a abstract factory to create one of the
//different variations of a Singleton. If such extensibility is not required,
//then the static method approach is quite reasonable and is a lot simpler.
//
//2. Is the singlton above guaranteed to have exactly one instance?
//Sadly no.
//For one, this is not thread safe.
//So we can fix that?
//We can try, but...

class DBManager {
  private static DBManager instance;
  private DBManager() {}

  //public static synchronized DBManager create() {
  //every caller pays a penalty even after the instance has been created.

  public static DBManager create() {
    if(instance == null) {
      synchronized(DBManager.class) {
        if(instance == null) {
          instance = new DBManager();
        }
      }
    }

    return instance;
    //How does that feel?
    //Looks complicated.
  }
}

public class Sample {
  public static void main(String[] args) {
    DBManager dbManager1 = DBManager.create();
    DBManager dbManager2 = DBManager.create();

    System.out.println(dbManager1 == dbManager2);
  }
}

