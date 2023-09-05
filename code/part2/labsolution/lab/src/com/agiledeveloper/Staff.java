package com.agiledeveloper;

public class Staff extends Employee {
  @Override
  protected FlightTicket bookFlightTicket() {
    return new EconomyTicket();
  }

  @Override
  protected Car bookCarRental() {
    return new EconomyCar();
  }

  @Override
  protected Hotel bookHotelReservation() {
    return new ThreeStarHotel();
  }
}
