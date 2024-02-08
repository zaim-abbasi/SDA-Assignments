package RenterPackage;

import CarPackage.Car;

public class FrequentRenter extends Renter {
  private int loyaltyPoints;

  public FrequentRenter(String renterId, String name, String email, String phoneNumber, String address) {
    super(renterId, name, email, phoneNumber, address);
    this.loyaltyPoints = 2; // Initialize loyalty points
  }

  @Override
  public double calculateDiscountedRate(double baseRent) {
    // Frequent renters have a loyalty program with discounted rates
    // You can define the discount logic based on loyalty points
    // For example, if loyaltyPoints >= 10, apply a 10% discount
    // Otherwise, no discount
    return baseRent * (1.0 - loyaltyPoints * 0.01);
  }

  @Override
  public String getRenterType() {
    return "Frequent Renter";
  }

  // Additional properties and methods specific to FrequentRenter
  // ...

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder(super.toString());
    result.append("\nLoyalty Points: ").append(loyaltyPoints);
    if (hasRentedCars()) {
      result.append("\nCars Rented: ").append(getRentedCars().size());
      for (Car rentedCar : getRentedCars()) {
        // result.append("\n").append(rentedCar);

        // display car details in a single line inside [] brackets like following: [Car
        // ID: 1, Brand: Toyota, Model: Sedan, Year: 2010, Plate Number: 12345, Rental
        // Fee: 100.0]
        result.append("\n[Car ID: ").append(rentedCar.getCarId()).append(", Brand: ").append(rentedCar.getBrand())
            .append(", Model: ").append(rentedCar.getModel()).append(", Year: ").append(rentedCar.getYear())
            .append(", Plate Number: ").append(rentedCar.getPlateNumber()).append("]");
        System.out.println("\n");
      }

    }
    return result.toString();

  }
}
