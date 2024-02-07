package CarPackage;

public class CompactCar extends Car {
  private final double MINIMUM_DAMAGE_COST = 200.0; // Adjust as needed

  public CompactCar(String carId, String brand, String model, int year, String plateNumber) {
    super(carId, brand, model, year, plateNumber);
  }

  @Override
  public double calculateRent(double distance) {
    // Implement the rent calculation for CompactCar
    // Base rent + distance traveled cost for compact cars
    // You need to define the base rent and distance cost formula
    return 0.0; // Placeholder, replace with actual calculation
  }

  @Override
  public double calculateInsuranceCost() {
    // CompactCar is not insurable, so return 0 for insurance cost
    return 0.0;
  }

  @Override
  public double calculateTotalCost() {
    // You need to define the formula for the total cost of CompactCar
    return 0.0; // Placeholder, replace with actual calculation
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
    return 50.0; // Adjust as needed
  }
  // Other methods specific to CompactCar
}
