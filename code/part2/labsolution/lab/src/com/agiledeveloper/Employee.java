package com.agiledeveloper;

public abstract class Employee {
  private FlightTicket flightTicket;
  private Car car;
  private Hotel hotel;

  public FlightTicket getFlightTicket() {
    return flightTicket;
  }

  public Car getCarRental() {
    return car;
  }

  public Hotel getHotel() {
    return hotel;
  }

  protected abstract FlightTicket bookFlightTicket();

  protected abstract Car bookCarRental();

  protected abstract Hotel bookHotelReservation();

  public final void bookTravel() {
    flightTicket = bookFlightTicket();
    car = bookCarRental();
    hotel = bookHotelReservation();
  }
}
