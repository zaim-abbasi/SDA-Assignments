package RenterPackage;

import CarPackage.Car;

public class RegularRenter extends Renter {

  public RegularRenter(String renterId, String name, String email, String phoneNumber, String address) {
    super(renterId, name, email, phoneNumber, address);
  }

  @Override
  public double calculateDiscountedRate(double baseRent) {
    // Regular renters have standard rates, so no discount
    return baseRent;
  }

  @Override
  public String getRenterType() {
    return "Regular Renter";
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder(super.toString());

    if (hasRentedCars()) {
      result.append("\nCars Rented: ").append(getRentedCars().size());
      double totalFare = 0.0;
      for (Car rentedCar : getRentedCars()) {
        result.append("\n[Car Type: ").append(rentedCar.getCarType())
            .append(", Car ID: ").append(rentedCar.getCarId())
            .append(", Brand: ").append(rentedCar.getBrand())
            .append(", Model: ").append(rentedCar.getModel())
            .append(", Year: ").append(rentedCar.getYear())
            .append(", Plate Number: ").append(rentedCar.getPlateNumber())
            .append(", Rental Fee: ").append(rentedCar.getRentalFee())
            .append("]");

        // // Calculate and display the fare details
        // double baseRent = rentedCar.getRentalFee();
        // double discount = calculateDiscountedRate(baseRent) - baseRent;
        // double totalCost = baseRent + rentedCar.calculateInsuranceCost() +
        // rentedCar.calculateDamageCost() - discount;
        // result.append(" (Total Fare: ").append(totalCost).append(" - Base Rent:
        // ").append(baseRent);
        // if (discount > 0) {
        // result.append(", Discount: ").append(discount);
        // }
        // result.append(")");

        // totalFare += totalCost;
      }
      // result.append("\nTotal Fare: ").append(totalFare);
    }

    return result.toString();
  }

  // Additional properties and methods specific to RegularRenter
  // ...
}
