import CarPackage.*;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
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
				// Other cases...
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
		System.out.println("\nCar Rental Management System Menu:");
		System.out.println("1. Add new car");
		System.out.println("2. Display available cars");
		System.out.println("3. Remove a car (if not rented)");
		// Other menu options...
		System.out.println("0. Exit");
		System.out.print("Enter your choice: ");
	}

	private static void addNewCar(Scanner scanner, CRMS crms) {
		System.out.print("Enter car type (1. Compact, 2. Luxury, 3. SUV): ");
		int carType = scanner.nextInt();
		System.out.print("Enter car ID: ");
		String carId = scanner.next();
		System.out.print("Enter car brand: ");
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
				System.out.print("Is SUV insurable? (true/false): ");
				boolean insurable = scanner.nextBoolean();
				car = new SUV(carId, brand, model, year, plateNumber, insurable);
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
		System.out.println("Enter the ID of the car to be removed: ");
		String carId = scanner.next();
		Car carToRemove = crms.findCarById(carId);

		if (carToRemove != null) {
			crms.removeCar(carToRemove);
		} else {
			System.out.println("Car with ID " + carId + " not found.");
		}
	}
	// Other methods...
}
