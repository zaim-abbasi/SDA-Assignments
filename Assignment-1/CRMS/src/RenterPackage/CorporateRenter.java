package RenterPackage;

import CarPackage.Car;
import CarPackage.LuxuryCar;
import CarPackage.SUV;

public class CorporateRenter extends Renter {
  private String companyName;
  private final double corporateDiscount = 0.20;

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
    return "Corporate Renter";
  }

  private double calculateLuxuryAndSUVDamageCost(Car rentedCar) {
    // Check if the rented car is LuxuryCar or SUV to calculate damage cost
    if (rentedCar instanceof LuxuryCar || rentedCar instanceof SUV) {
      return rentedCar.calculateDamageCost();
    }
    return 0.0; // Return 0 if the car is not LuxuryCar or SUV
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder(super.toString() + "\nCompany Name: " + companyName);

    if (hasRentedCars()) {
      int numberOfCarsRented = getRentedCars().size();
      result.append("\nCars Rented: ");
      if (numberOfCarsRented > 0) {
        result.append(numberOfCarsRented);
        for (Car rentedCar : getRentedCars()) {
          result.append("\n[Car Type: ").append(rentedCar.getCarType())
              .append(", Car ID: ").append(rentedCar.getCarId())
              .append(", Brand: ").append(rentedCar.getBrand())
              .append(", Model: ").append(rentedCar.getModel())
              .append(", Year: ").append(rentedCar.getYear())
              .append(", Plate Number: ").append(rentedCar.getPlateNumber());

          result.append("]");

          // Use the helper method to calculate damage cost for LuxuryCar and SUV
          double damageCost = calculateLuxuryAndSUVDamageCost(rentedCar);

          double corpDiscount = rentedCar.calculateTotalCost();
          corpDiscount -= (corporateDiscount * rentedCar.calculateTotalCost());
          result.append("\nTotal Rent(Incl. special discount): ").append(corpDiscount);
          if (damageCost > 0)
            result.append("\nDamage Cost: ").append(damageCost);

          // check if the car has insurance, if car is insurable, then show insurance cost
          if (rentedCar.isInsurable() && rentedCar.hasInsurance()) {
            result.append("\nInsurance Cost: ").append(rentedCar.calculateInsuranceCost());
          }
        }
      } else {
        result.append("No cars rented");
      }
    } else {
      result.append("\nCars Rented: No cars rented");
    }

    return result.toString();
  }

  // Additional properties and methods specific to CorporateRenter
  // ...
}
