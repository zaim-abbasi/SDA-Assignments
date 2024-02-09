package CarPackage;

public abstract class Car {
  private String carId;
  private String brand;
  private String model;
  private int year;
  private boolean rentalStatus;
  private double rentalFee;
  private String plateNumber;
  private Double distance;

  private final double DAMAGE_PERCENTAGE_INSURED = 0.2; // 20% for example

  private final double MINIMUM_DAMAGE_COST = 500.0;

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
    double TotalCost = calculateTotalCost();
    double DamageCost_Insured = 0.0;

    if(this instanceof LuxuryCar || this instanceof SUV) {
      if(isInsurable() && hasInsurance()) {
        System.out.println("\nCar is Insured\n");
        double insuranceCost = calculateInsuranceCost();
        DamageCost_Insured = Math.max(MINIMUM_DAMAGE_COST, (DAMAGE_PERCENTAGE_INSURED * TotalCost) - insuranceCost);
      }
    }
    return DamageCost_Insured;
  }


  public abstract double getBaseRent();

  @Override
  public String toString() {
    return "\nCar Type: " + getCarType() +
        "\nCar ID: " + carId +
        "\nBrand: " + brand +
        "\nModel: " + model +
        "\nYear: " + year +
        "\nPlate Number: " + plateNumber;
  }

  public abstract String getCarType(); // Abstract method to be implemented in each subclass

  public void setRented(boolean rentalStatus) {
    this.rentalStatus = rentalStatus;
  }

  public void setDistance(Double distance) {
    this.distance = distance;
  }

  public Double getDistance() {
    return distance;
  }

}
