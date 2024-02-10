package CarPackage;

public class SUV extends Car {
  private final double pricePerKm = 20;
  private final double baseRent = 50.0;

  private final double INSURANCE_PERCENTAGE = 0.30; // Fixed percentage for insurance
  private final double MINIMUM_DAMAGE_COST = 1000.0;

  public SUV(String carId, String brand, String model, int year, String plateNumber) {
    super(carId, brand, model, year, plateNumber);
  }

  @Override
  public double calculateRent(double distance) {
    return getBaseRent() * distance + pricePerKm * distance;
  }

  @Override
  public double calculateInsuranceCost() {
    return (getBaseRent() + pricePerKm * getDistance()) * INSURANCE_PERCENTAGE; // Adjust the percentage as needed
  }

  @Override
  public double calculateTotalCost() {
    return calculateRent(getDistance());
  }

  @Override
  public boolean isInsurable() {
    return true;
  }

  @Override
  public boolean hasInsurance() {
    return true;
  }

  @Override
  public double getBaseRent() {
    return baseRent;
  }

  @Override
  public String toString() {
    return super.toString();
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
