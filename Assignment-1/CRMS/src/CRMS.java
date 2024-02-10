import java.util.ArrayList;
import java.util.List;

import CarPackage.*;
import RenterPackage.*;

public class CRMS {
  private List<Car> cars;
  private List<Renter> renters;
  private List<RentalTransaction> rentalTransactions;

  public CRMS() {
    this.cars = new ArrayList<>();
    this.renters = new ArrayList<>();
    this.rentalTransactions = new ArrayList<>();
  }

  // Car Management
  public void addNewCar(Car car) {
    if (!carIdExists(car.getCarId())) {
      cars.add(car);
    } else {
      System.out.println("Car with the same ID already exists. Please enter a unique ID.");
    }
  }

  public boolean renterIdExists(String renterId) {
    for (Renter renter : renters) {
      if (renter.getRenterId().equals(renterId)) {
        return true; // Renter with the same ID already exists
      }
    }
    return false; // Renter with the given ID does not exist
  }

  public Renter findRenterById(String renterId) {
    for (Renter renter : renters) {
      if (renter.getRenterId().equals(renterId)) {
        return renter;
      }
    }
    return null;
  }

  public void displayAvailableCars() {
    System.out.println("\n╔════════════════════════════════════════╗");
    System.out.println(  "║              Available Cars            ║");
    System.out.println(  "╚════════════════════════════════════════╝");

    for (Car car : cars) {
      if (!car.isRented()) {
        System.out.println(car);
      }
    }
  }

  public void removeCar(Car car) {
    if (!car.isRented()) {
      cars.remove(car);
      car.setRented(false); // Set the rental status to false
      System.out.println("Car removed successfully.");
    } else {
      System.out.println("Cannot remove a rented car.");
    }
  }

  // finding a car by ID
  public Car findCarById(String carId) {
    for (Car car : cars) {
      if (car.getCarId().equals(carId)) {
        return car;
      }
    }
    return null;
  }

  public void addNewRenter(Renter renter) {
    if (!renterIdExists(renter.getRenterId())) {
      renters.add(renter);
    } else {
      System.out.println("Renter with the same ID already exists. Please choose a different ID.");
    }
  }

  public void displayRenterDetails() {
    System.out.println("\n╔════════════════════════════════════════╗");
    System.out.println(  "║              Renter Details            ║");
    System.out.println(  "╚════════════════════════════════════════╝");
    for (Renter renter : renters) {
      System.out.println(renter);
    }
  }

  public void removeRenter(Renter renter) {
    if (renter.hasRentedCars()) {
      System.out.println("Cannot remove a renter with rented cars.");
    } else {
      renters.remove(renter);
      System.out.println("Renter removed successfully.");
    }
  }

  // Rent Transactions
  public void rentCar(Renter renter, Car car, double distance) {
    if (!car.isRented()) {
      RentalTransaction transaction = new RentalTransaction(renter, car, distance);
      rentalTransactions.add(transaction);
      renter.addRentedCar(car);
      car.setRented(true);
      System.out.println("Rent successful.");
    } else {
      System.out.println("Car is already rented.");
    }
  }

  public void unrentCar(Renter renter, Car carToUnrent) {
    RentalTransaction transaction = findRentalTransaction(renter, carToUnrent);
    if (transaction != null) {
      rentalTransactions.remove(transaction);
      renter.removeRentedCar(carToUnrent);
      carToUnrent.setRented(false);
    } else {
      System.out.println("Rental transaction not found. Unable to unrent the car.");
    }
  }

  public double calculateTotalRentalCost(RentalTransaction transaction) {
    return transaction.calculateTotalCost();
  }

  public void addInsurance(RentalTransaction transaction) {
    Car car = transaction.getCar();
    if (car.isInsurable() && !transaction.isInsuranceAdded()) {
      transaction.addInsurance();
      System.out.println("Insurance added successfully.");
    } else {
      System.out.println("Insurance cannot be added. Check if the car is insurable or if insurance is already added.");
    }
  }

  public void addInsurance(Renter renter, Car car) {
    RentalTransaction transaction = findRentalTransaction(renter, car);
    if (transaction != null) {
      addInsurance(transaction);
    } else {
      System.out.println("Rental transaction not found. Unable to add insurance.");
    }
  }

  public double calculateTotalRentalCost(Renter renter, Car car, double distance) {
    RentalTransaction transaction = findRentalTransaction(renter, car);
    if (transaction != null) {
      return calculateTotalRentalCost(transaction);
    } else {
      System.out.println("Rental transaction not found. Unable to calculate total rental cost.");
      return 0.0;
    }
  }

  public double calculateDamageCost(Renter renter, Car car) {
    RentalTransaction transaction = findRentalTransaction(renter, car);
    if (transaction != null) {
      return calculateDamageCost(transaction);
    } else {
      System.out.println("Rental transaction not found. Unable to calculate damage cost.");
      return 0.0;
    }
  }

  public boolean carIdExists(String carId) {
    for (Car car : cars) {
      if (car.getCarId().equals(carId)) {
        return true;
      }
    }
    return false;
  }

  private RentalTransaction findRentalTransaction(Renter renter, Car car) {
    for (RentalTransaction transaction : rentalTransactions) {
      if (transaction.getRenter() == renter && transaction.getCar() == car) {
        return transaction;
      }
    }
    return null;
  }

  public double calculateDamageCost(RentalTransaction transaction) {
    Car car = transaction.getCar();
    double damageCost = car.calculateDamageCost();

    // For Insured Cars: Damage cost is a percentage of the total cost minus the insurance cost
    if (car.isInsurable() && transaction.isInsuranceAdded()) {
      double insuranceCost = car.calculateInsuranceCost();
      double totalCost = transaction.calculateTotalCost();
      double damageCostWithInsurance = totalCost - insuranceCost;
      damageCost = Math.max(damageCost, damageCostWithInsurance);

    }

    return damageCost;
  }

  // function to display all the rental transactions
  public void displayRentalTransactions() {
    System.out.println("\n╔════════════════════════════════════════╗");
    System.out.println(  "║            Rental Transactions         ║");
    System.out.println(  "╚════════════════════════════════════════╝");
    for (RentalTransaction transaction : rentalTransactions) {
      System.out.println(transaction);
    }
  }
}

