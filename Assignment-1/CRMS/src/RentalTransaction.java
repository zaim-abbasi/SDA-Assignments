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
      totalCost += car.calculateInsuranceCost();
    }
    return totalCost;
  }

  public double calculateDamageCost() {
    return car.calculateDamageCost();
  }

  // Getters
  public Renter getRenter() {
    return renter;
  }


  public Car getCar() {
    return car;
  }

  public double getDistance() {
    return distance;
  }

  public boolean isInsuranceAdded() {
    return insuranceAdded;
  }

  @Override
  public String toString() {
    return "Rental Transaction Details:" +
        "\nRenter ID: " + renter.getRenterId() +
        "\nCar ID: " + car.getCarId() +
        "\nDistance Traveled: " + String.format("%.2f", distance) + " km" +
        "\nInsurance Added: " + (insuranceAdded ? "Yes" : "No");
  }
  
}
