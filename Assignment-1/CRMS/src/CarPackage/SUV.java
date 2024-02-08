package CarPackage;

public class SUV extends Car {
  private boolean insurable;
  private final double INSURANCE_PERCENTAGE = 0.1; // Fixed percentage for insurance
  private final double MINIMUM_DAMAGE_COST = 50.0; // Adjust as needed

  public SUV(String carId, String brand, String model, int year, String plateNumber) {
    super(carId, brand, model, year, plateNumber);
  }

  @Override
  public double calculateRent(double distance) {
    // Implement the rent calculation for SUV
    // Base rent + distance traveled cost for SUVs
    return getBaseRent() + distance;
  }

  @Override
  public double calculateInsuranceCost() {
    // Implement the insurance cost calculation for SUV
    // Fixed percentage of the base rent
    return getBaseRent() * INSURANCE_PERCENTAGE; // Adjust the percentage as needed
  }

  @Override
  public double calculateTotalCost() {
    // Total cost includes base rent and distance cost
    return calculateRent(getDistance()) + calculateInsuranceCost();
  }

  @Override
  public boolean isInsurable() {
    return true;
  }

  @Override
  public boolean hasInsurance() {
    // You need to define the logic for whether SUV has insurance
    return true; // Placeholder, replace with actual logic
  }

  // Other methods specific to SUV
  @Override
  public double getBaseRent() {
    // Define the base rent for SUV
    return 70.0; // Adjust as needed
  }

  @Override
  public String toString() {
    return super.toString();
    // +
    // "\nInsurable: " + insurable +
    // "\nType: SUV\n"; // Specify the type
  }

  @Override
  public double getMinimumDamageCost() {
    return MINIMUM_DAMAGE_COST;
  }

  @Override
  public String getCarType() {
    return "SUV Car";
  }

}
