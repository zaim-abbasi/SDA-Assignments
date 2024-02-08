package RenterPackage;

import CarPackage.Car;

public class CorporateRenter extends Renter {
  private String companyName;

  public CorporateRenter(String renterId, String name, String email, String phoneNumber, String address,
      String companyName) {
    super(renterId, name, email, phoneNumber, address);
    this.companyName = companyName;
  }

  @Override
  public double calculateDiscountedRate(double baseRent) {
    // Corporate renters have special rates
    // You can define the discount logic based on corporate rules
    // For example, apply a fixed discount percentage for corporate renters
    return baseRent * 0.9; // 10% discount for illustration
  }

  public String getRenterType() {
    return "Regular Renter";
  }

  @Override
  public String toString() {
    // return super.toString() +
    // "\nCompany Name: " + companyName;
    StringBuilder result = new StringBuilder(super.toString() + "\nCompany Name: " + companyName);
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
      }

    }
    return result.toString();
  }

  // Additional properties and methods specific to CorporateRenter
  // ...
}
