package CarPackage;

public class CompactCar extends Car {
  // private final double MINIMUM_DAMAGE_COST = 200.0; // Adjust as needed
  private final double pricePerKm = 10; // Adjust as needed
  private final double baseRent = 30.0; // Adjust as needed
  public CompactCar(String carId, String brand, String model, int year, String plateNumber) {
    super(carId, brand, model, year, plateNumber);
  }

  @Override
  public double calculateRent(double distance) {
    return (baseRent*distance) + (pricePerKm * distance);
  }

  @Override
  public double calculateInsuranceCost() {
    // CompactCar is not insurable, so return 0 for insurance cost
    return 0.0;
  }

  @Override
  public double calculateTotalCost() {
    // Total cost includes base rent, distance cost, and luxury tax
    return calculateRent(getDistance());
  }

  @Override
  public boolean isInsurable() {
    return false;
  }

  @Override
  public boolean hasInsurance() {
    return false;
  }

  @Override
  public double getBaseRent() {
    // Define the base rent for CompactCar
    return baseRent;
  }
  

  // Other methods specific to CompactCar
  @Override
  public double getMinimumDamageCost() {
    return 0.0; // No minimum damage cost for CompactCar
  }

  @Override
  public String getCarType() {
    return "Compact Car";
  }
}
