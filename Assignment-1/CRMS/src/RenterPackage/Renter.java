package RenterPackage;

import CarPackage.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Renter {
  private String renterId;
  private String name;
  private String email;
  private List<Car> rentedCars;
  private double totalRentalFee;
  private String phoneNumber;
  private String address;

  public Renter(String renterId, String name, String email, String phoneNumber, String address) {
    this.renterId = renterId;
    this.name = name;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.totalRentalFee = 0.0; // Initialize total rental fee
    this.rentedCars = new ArrayList<>(); // Initialize rentedCars list
  }

  
  public abstract double calculateDiscountedRate(double baseRent);

  public boolean hasRentedCars() {
    return rentedCars != null && !rentedCars.isEmpty();
  }

  // all getters
  public String getRenterId() {
    return renterId;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public List<Car> getRentedCars() {
    return rentedCars;
  }

  public double getTotalRentalFee() {
    return totalRentalFee;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getAddress() {
    return address;
  }

  // all setters
  public void setRenterId(String renterId) {
    this.renterId = renterId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setRentedCars(List<Car> rentedCars) {
    this.rentedCars = rentedCars;
  }

  public void setTotalRentalFee(double totalRentalFee) {
    this.totalRentalFee = totalRentalFee;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void addRentedCar(Car car) {
    rentedCars.add(car);
  }

  @Override
  public String toString() {
    // Return a string representation of Renter details
    return String.format("Renter ID: %s, Name: %s, Email: %s, Phone: %s, Address: %s",
            renterId, name, email, phoneNumber, address);
  }
}
