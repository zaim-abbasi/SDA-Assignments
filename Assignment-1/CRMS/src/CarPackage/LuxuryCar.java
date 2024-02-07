package CarPackage;

public class LuxuryCar extends Car {
  private double luxuryTax;
  private final double MINIMUM_DAMAGE_COST = 100.0; // Adjust as needed

  public LuxuryCar(String carId, String brand, String model, int year, String plateNumber, double luxuryTax) {
    super(carId, brand, model, year, plateNumber);
    this.luxuryTax = luxuryTax;
  }

  @Override
  public double calculateRent(double distance) {
    // Implement the rent calculation for LuxuryCar
    // Base rent + distance traveled cost + luxury tax for luxury cars
    return getBaseRent() + distance + luxuryTax;
  }

  @Override
  public double calculateInsuranceCost() {
    // Implement the insurance cost calculation for LuxuryCar
    // Fixed percentage of the base rent
    return getBaseRent() * 0.1; // Adjust the percentage as needed
  }

  @Override
  public double calculateTotalCost() {
    // Total cost includes base rent, distance cost, and luxury tax
    return getBaseRent() + luxuryTax;
  }

  @Override
  public boolean isInsurable() {
    return true;
  }

  @Override
  public boolean hasInsurance() {
    // You need to define the logic for whether LuxuryCar has insurance
    return false; // Placeholder, replace with actual logic
  }

  // Other methods specific to LuxuryCar
  @Override
  public double getBaseRent() {
    // Define the base rent for LuxuryCar
    return 100.0; // Adjust as needed
  }

  @Override
  public String toString() {
    return super.toString() +
        "\nLuxury Tax: " + luxuryTax + "\n";
  }

}
