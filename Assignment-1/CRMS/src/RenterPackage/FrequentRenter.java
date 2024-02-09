package RenterPackage;

import CarPackage.Car;
import CarPackage.LuxuryCar;
import CarPackage.SUV;

public class FrequentRenter extends Renter {
  private final double loyaltyPoints = 0.15;

  public FrequentRenter(String renterId, String name, String email, String phoneNumber, String address) {
    super(renterId, name, email, phoneNumber, address);
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
      result.append("\nLoyalty Discount: ").append(loyaltyPoints * 100).append(" %");

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

            double loyaltyDiscount = rentedCar.calculateTotalCost();
            loyaltyDiscount -= (loyaltyPoints * rentedCar.calculateTotalCost());
            result.append("\nTotal Rent(Incl. Loyality): ").append(loyaltyDiscount);
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

}
