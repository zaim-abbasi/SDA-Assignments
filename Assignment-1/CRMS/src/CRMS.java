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
    cars.add(car);
  }

  public void displayAvailableCars() {
    System.out.println("Available Cars:");
    for (Car car : cars) {
      if (!car.isRented()) {
        System.out.println(car);
      }
    }
  }

  public void removeCar(Car car) {
    if (!car.isRented()) {
      cars.remove(car);
      System.out.println("Car removed successfully.");
    } else {
      System.out.println("Cannot remove a rented car.");
    }
  }

  // Additional methods for finding a car by ID
  public Car findCarById(String carId) {
    for (Car car : cars) {
      if (car.getCarId().equals(carId)) {
        return car;
      }
    }
    return null;
  }

  // Renter Management
  public void addNewRenter(Renter renter) {
    renters.add(renter);
  }

  public void displayRenterDetails() {
    System.out.println("Renter Details:");
    for (Renter renter : renters) {
      System.out.println(renter);
    }
  }

  public void removeRenter(Renter renter) {
    renters.remove(renter);
    System.out.println("Renter removed successfully.");
  }

  // Rent Transactions
  public void rentCar(Renter renter, Car car, double distance) {
    if (!car.isRented()) {
      RentalTransaction transaction = new RentalTransaction(renter, car, distance);
      rentalTransactions.add(transaction);
      renter.addRentedCar(car);
      //car.setRented(true);
      System.out.println("Rent successful. Rental details: " + transaction);
    } else {
      System.out.println("Car is already rented.");
    }
  }

  public void displayRentalDetails(RentalTransaction transaction) {
    System.out.println("Rental Details: " + transaction);
  }

  public double calculateTotalRentalCost(RentalTransaction transaction) {
    return transaction.calculateTotalCost();
  }

  public void addInsurance(RentalTransaction transaction) {
    transaction.addInsurance();
    System.out.println("Insurance added successfully.");
  }

  // public double calculateDamageCost(RentalTransaction transaction) {
  //   return transaction.calculateDamageCost();
  // }

  // Other methods for managing the car rental system
}
