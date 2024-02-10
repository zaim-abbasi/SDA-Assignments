package CarPackage;

public class LuxuryCar extends Car {
  private double luxuryTax;
  private final double INSURANCE_PERCENTAGE = 0.1; // 10% for example
  private final double MINIMUM_DAMAGE_COST = 500.0;

  private final double pricePerKm = 15;
  private final double baseRent = 40.0;

  public LuxuryCar(String carId, String brand, String model, int year, String plateNumber, double luxuryTax) {
    super(carId, brand, model, year, plateNumber);
    this.luxuryTax = luxuryTax;
  }

  @Override
  public double calculateRent(double distance) {
    return (baseRent * distance) + pricePerKm * distance + luxuryTax;
  }

  @Override
  public double calculateInsuranceCost() {
    return getBaseRent() * INSURANCE_PERCENTAGE;
  }

  @Override
  public double calculateTotalCost() {
    return calculateRent(getDistance()) + calculateInsuranceCost();
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
    return baseRent * getDistance();
  }

  @Override
  public String toString() {
    return super.toString() +
        "\nLuxury Tax: " + luxuryTax;
  }

  @Override
  public String getCarType() {
    return "Luxury Car";
  }

  @Override
  public double getMinimumDamageCost() {
    return MINIMUM_DAMAGE_COST;
  }

}
