import CarPackage.*;
import RenterPackage.*;
public class RentalTransaction {
  private Renter renter;
  private Car car;
  private double distance;
  private boolean insuranceAdded;

  public RentalTransaction(Renter renter, Car car, double distance) {
    this.renter = renter;
    this.car = car;
    this.distance = distance;
    this.insuranceAdded = false;
  }

  public void addInsurance() {
    insuranceAdded = true;
  }

  public double calculateTotalCost() {
    double totalCost = car.calculateRent(distance);
    if (insuranceAdded) {
      //totalCost += car.calculateInsuranceCost();
    }
    return totalCost;
  }

  // public double calculateDamageCost() {
  //   //return car.calculateDamageCost();
  // }

  // Getters and other methods
  // ...
}
