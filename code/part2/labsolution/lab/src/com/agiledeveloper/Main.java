package com.agiledeveloper;

public class Main {
  public static void bookTravelFor(Employee employee) {
    employee.bookTravel();
  }

  public static void printTravelDetailsFor(Employee employee) {
    System.out.println("------");
    System.out.println("Travel details for " + employee.getClass().getSimpleName());

    System.out.println(employee.getFlightTicket());
    System.out.println(employee.getCarRental());
    System.out.println(employee.getHotel());
  }

  public static void main(String[] args) {
    Staff staff = new Staff();
    SalesPerson salesPerson = new SalesPerson();
    Executive executive = new Executive();

    bookTravelFor(staff);
    bookTravelFor(salesPerson);
    bookTravelFor(executive);

    printTravelDetailsFor(staff);
    printTravelDetailsFor(salesPerson);
    printTravelDetailsFor(executive);
  }
}

/*
The output when the program is run should be:

------
Travel details for Staff
EconomyTicket
EconomyCar
ThreeStarHotel
------
Travel details for SalesPerson
BusinessClassTicket
LuxuryCar
ThreeStarHotel
------
Travel details for Executive
FirstClassTicket
LuxuryCar
FiveStarHotel

 */
