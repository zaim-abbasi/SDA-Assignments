package CarPackage;

public abstract class Car {
  private String carId;
  private String brand;
  private String model;
  private int year;
  private boolean rentalStatus;
  private double rentalFee;
  private String plateNumber;

  private final double DAMAGE_COST_PERCENTAGE = 0.1; // 10% for example

  private final double MINIMUM_DAMAGE_COST = 100.0; // 100 for example

  public Car(String carId, String brand, String model, int year, String plateNumber) {
    this.carId = carId;
    this.brand = brand;
    this.model = model;
    this.year = year;
    this.plateNumber = plateNumber;
    this.rentalStatus = false; // Initially not rented
  }

  // getters, setters, and other methods
  public String getCarId() {
    return carId;
  }

  public String getBrand() {
    return brand;
  }

  public String getModel() {
    return model;
  }

  public int getYear() {
    return year;
  }

  public boolean isRented() {
    return rentalStatus;
  }

  public double getRentalFee() {
    return rentalFee;
  }

  public String getPlateNumber() {
    return plateNumber;
  }

  // all setters
  public void setCarId(String carId) {
    this.carId = carId;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public void setRentalStatus(boolean rentalStatus) {
    this.rentalStatus = rentalStatus;
  }

  public void setRentalFee(double rentalFee) {
    this.rentalFee = rentalFee;
  }

  public void setPlateNumber(String plateNumber) {
    this.plateNumber = plateNumber;
  }

  public abstract double calculateRent(double distance);

  public abstract double calculateInsuranceCost();

  public abstract double calculateTotalCost();

  public abstract boolean isInsurable();

  public abstract boolean hasInsurance();


  public abstract double getMinimumDamageCost();

  public double calculateDamageCost() {
    double totalCost = calculateTotalCost();

    // For all Cars: Damage cost is a percentage of the total cost decided by the
    // company
    double damageCost = totalCost * DAMAGE_COST_PERCENTAGE;

    // For Insured Cars: Damage cost is a percentage of the total cost minus the
    // insurance
    // but with a minimum set if damage is apparent.
    if (isInsurable() && hasInsurance()) {
      double insuranceCost = calculateInsuranceCost();
      double remainingCost = totalCost - insuranceCost;
      damageCost = Math.max(damageCost, MINIMUM_DAMAGE_COST);
    }

    return damageCost;
  }
  
  public abstract double getBaseRent();

  @Override
  public String toString() {
    return "\n" + "Car ID: " + carId +
        "\nBrand: " + brand +
        "\nModel: " + model +
        "\nYear: " + year +
        "\nRental Status: " + rentalStatus +
        "\nRental Fee: " + rentalFee +
        "\nPlate Number: " + plateNumber;
  }

  public void setRented(boolean rentalStatus) {
    this.rentalStatus = rentalStatus;
  }

}
