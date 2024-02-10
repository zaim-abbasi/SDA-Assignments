import CarPackage.*;
import RenterPackage.*;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		clearScreen();
		Scanner scanner = new Scanner(System.in);
		CRMS crms = new CRMS();

		int choice;
		do {
			displayMenu();
			choice = scanner.nextInt();

			switch (choice) {
				case 1:
					addNewCar(scanner, crms);
					break;
				case 2:
					displayAvailableCars(crms);
					break;
				case 3:
					removeCar(scanner, crms);
					break;
				case 4:
					addNewRenter(scanner, crms);
					break;
				case 5:
					displayRenterDetails(crms);
					break;
				case 6:
					removeRenter(scanner, crms);
					break;
				case 7:
					rentCar(scanner, crms);
					break;
				case 8:
					unrentCar(scanner, crms);
					break;
				case 9:
					crms.displayRentalTransactions();
					break;
				case 0:
					System.out.println("Exiting the program. Goodbye!");
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 0);

		scanner.close();
	}

	private static void displayMenu() {
		System.out.println("\n╔════════════════════════════════════════╗");
		System.out.println(  "║         Welcome to Car Rental          ║");
		System.out.println(  "║              Management System         ║");
		System.out.println(  "║           Choose an option below       ║");
		System.out.println(  "╠════════════════════════════════════════╣");
		System.out.println(  "║ 1. Add a new car                       ║");
		System.out.println(  "║ 2. Display available cars              ║");
		System.out.println(  "║ 3. Remove a car (if not rented)        ║");
		System.out.println(  "║ 4. Add a new renter                    ║");
		System.out.println(  "║ 5. Display renter details              ║");
		System.out.println(  "║ 6. Remove a renter                     ║");
		System.out.println(  "║ 7. Rent a car                          ║");
		System.out.println(  "║ 8. Unrent a car                        ║");
		System.out.println(  "║ 9. Display all Rental Transactions     ║");
		System.out.println(  "║ 0. Exit                                ║");
		System.out.println(  "╚════════════════════════════════════════╝");
		System.out.print("Enter your choice: ");
	}

	private static void addNewCar(Scanner scanner, CRMS crms) {
		// adds a new car to the system
		System.out.print("Enter car type (1. Compact, 2. Luxury, 3. SUV): ");
		int carType = scanner.nextInt();
		System.out.print("Enter car ID: ");
		String carId = scanner.next();

		// Check if the car ID already exists
		while (crms.carIdExists(carId)) {
			System.out.println("Car with the same ID already exists. Please enter a unique ID: ");
			carId = scanner.next();
		}

		System.out.print("Enter car make: ");
		String brand = scanner.next();
		System.out.print("Enter car model: ");
		String model = scanner.next();
		System.out.print("Enter car year: ");
		int year = scanner.nextInt();
		System.out.print("Enter car plate number: ");
		String plateNumber = scanner.next();

		Car car = null;
		switch (carType) {
			case 1:
				car = new CompactCar(carId, brand, model, year, plateNumber);
				break;
			case 2:
				System.out.print("Enter luxury tax for Luxury Car: ");
				double luxuryTax = scanner.nextDouble();
				car = new LuxuryCar(carId, brand, model, year, plateNumber, luxuryTax);
				break;
			case 3:
				car = new SUV(carId, brand, model, year, plateNumber);
				break;
			default:
				System.out.print("Invalid car type.");
		}

		if (car != null) {
			crms.addNewCar(car);
			System.out.println("Car added successfully.");
		}
	}

	private static void displayAvailableCars(CRMS crms) {
		crms.displayAvailableCars();
	}

	private static void removeCar(Scanner scanner, CRMS crms) {
		System.out.println("\nEnter the ID of the car to be removed: ");
		String carId = scanner.next();
		Car carToRemove = crms.findCarById(carId);

		// if car is not rented, remove it
		if (carToRemove != null) {
			crms.removeCar(carToRemove);
		} else {
			System.out.println("Car with ID " + carId + " not found.");
		}
	}

	private static void addNewRenter(Scanner scanner, CRMS crms) {
		// adds a new renter to the system
		System.out.print("Enter renter type (1. Regular, 2. Frequent, 3. Corporate): ");
		int renterType = scanner.nextInt();
		System.out.print("Enter renter ID: ");
		String renterId = scanner.next();

		// Check if renter ID already exists
		while (crms.renterIdExists(renterId)) {
			System.out.println("Renter with the same ID already exists. Please enter a unique ID: ");
			renterId = scanner.next();
		}

		System.out.print("Enter renter name: ");
		String name = scanner.next();
		System.out.print("Enter renter email: ");
		String email = scanner.next();
		System.out.print("Enter renter phone number: ");
		String phoneNumber = scanner.next();
		System.out.print("Enter renter address: ");
		String address = scanner.next();

		Renter renter = null;

		switch (renterType) {
			case 1:
				renter = new RegularRenter(renterId, name, email, phoneNumber, address);
				break;
			case 2:
				renter = new FrequentRenter(renterId, name, email, phoneNumber, address);
				break;
			case 3:
				System.out.print("Enter company name for Corporate Renter: ");
				String companyName = scanner.next();
				renter = new CorporateRenter(renterId, name, email, phoneNumber, address, companyName);
				break;
			default:
				System.out.print("Invalid renter type.");
		}

		if (renter != null) {
			crms.addNewRenter(renter);
			System.out.println("Renter added successfully.");
		}
	}

	private static void displayRenterDetails(CRMS crms) {
		crms.displayRenterDetails();
	}

	private static void removeRenter(Scanner scanner, CRMS crms) {
		System.out.println("\nEnter the ID of the renter to be removed: ");
		String renterId = scanner.next();
		Renter renterToRemove = crms.findRenterById(renterId);

		if (renterToRemove != null) {
			crms.removeRenter(renterToRemove);
		} else {
			System.out.println("Renter with ID " + renterId + " not found.");
		}
	}
	public static void rentCar(Scanner scanner, CRMS crms) {
		 System.out.print("Enter renter ID: "); 
		 String renterId = scanner.next(); 
		 Renter renter = crms.findRenterById(renterId);
			if (renter != null) { 	// check if renter exists
				System.out.print("Enter car ID: ");
				String carId = scanner.next();
				Car car = crms.findCarById(carId);

				if (car != null) {
					System.out.print("Enter distance to be traveled: ");
					double distance = scanner.nextDouble();
					// set distance to car
					car.setDistance(distance);
					crms.rentCar(renter, car, distance);

					System.out.print("Do you want to add insurance? (1. Yes, 2. No): ");
					int addInsuranceChoice = scanner.nextInt();
					if (addInsuranceChoice == 1) {
						crms.addInsurance(renter, car);
					}
					System.out.println("Car rented successfully.");
					System.out.println("Total rent: " + car.calculateRent(distance));

				} else {
					System.out.println("Car with ID " + carId + " not found.");
				}
			} 
			else {
				System.out.println("Renter with ID " + renterId + " not found.");
			}
		}

	private static void unrentCar(Scanner scanner, CRMS crms) {
		System.out.print("Enter renter ID: ");
		String renterId = scanner.next();
		Renter renter = crms.findRenterById(renterId);

		if (renter != null && renter.hasRentedCars()) {
			System.out.print("Enter car ID to unrent: ");
			String carId = scanner.next();
			Car carToUnrent = renter.findRentedCarById(carId);

			if (carToUnrent != null) {
				crms.unrentCar(renter, carToUnrent);
				System.out.println("Car unrented successfully.");
			} else {
				System.out.println("Car with ID " + carId + " not found.");
			}
		} else {
			System.out.println("Renter with ID " + renterId + " not found or has no rented cars.");
		}
	}
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}
