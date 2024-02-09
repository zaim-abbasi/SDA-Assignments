package RenterPackage;

import CarPackage.Car;
import CarPackage.LuxuryCar;
import CarPackage.SUV;

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
  
  private double calculateLuxuryAndSUVDamageCost(Car rentedCar) {
    // Check if the rented car is LuxuryCar or SUV to calculate damage cost
    if (rentedCar instanceof LuxuryCar || rentedCar instanceof SUV) {
      return rentedCar.calculateDamageCost();
    }
    return 0.0; // Return 0 if the car is not LuxuryCar or SUV
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder(super.toString());

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
          result.append("\nTotal Rent: ").append(rentedCar.calculateTotalCost());
          
          if (rentedCar.isInsurable() && rentedCar.hasInsurance()) {
            double damageCost = calculateLuxuryAndSUVDamageCost(rentedCar);
            if (damageCost > 0)
              result.append("\nDamage Cost: ").append(damageCost);
            
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


  // Additional properties and methods specific to RegularRenter
  // ...
}
