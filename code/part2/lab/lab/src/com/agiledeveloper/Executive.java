package com.agiledeveloper;

public class Executive extends Employee {
  @Override
  protected FlightTicket bookFlightTicket() {
    return new FirstClassTicket();
  }

  @Override
  protected Car bookCarRental() {
    return new LuxuryCar();
  }

  @Override
  protected Hotel bookHotelReservation() {
    return new FiveStarHotel();
  }
}
