package com.agiledeveloper;

public class SalesPerson extends Employee {
  @Override
  protected FlightTicket bookFlightTicket() {
    return new EconomyTicket();
  }

  @Override
  protected Car bookCarRental() {
    return new LuxuryCar();
  }

  @Override
  protected Hotel bookHotelReservation() {
    return new ThreeStarHotel();
  }
}
