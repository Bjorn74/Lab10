import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CarSalesApp {

	public static void main(String[] args) {
		// Initialize
		Scanner scan = new Scanner(System.in);

		// Print Banner
		System.out.println("Welcome to the Grand Circus Car Inventory Management System.\n\t\tDon't forget to be Awesome!");

		// Build Data Structure
		// ArrayList will be most functional for adding and removing
		// Rows but still allowing for indexing

		ArrayList<Car> carList = new ArrayList<Car>();

		// If Empty, require user to add data
		while (carList.isEmpty()) {
			int num = 1;
			System.out.println("The List is currently Empty. \nPlease add a car to continue.\n");
			addCar(carList, num, scan);
		}

		// Enter Function Menu
		showCars(carList);
		carLotMenu(carList, scan);

		// Exit Routine
		
		System.out.println("Thank you for using the Grand Circus Car Inventory Control System.\n\t\tDon't forget to be Awesome!");
	
		// Clean Up
		scan.close();
		
	
	}

	public static void carLotMenu(ArrayList<Car> carList, Scanner scan) {
		// Initialize Variable for loop
		char response = ' ';

		while (response != 'x' && response != 'X') {
			System.out.println();
			System.out.println(
					"Would you like to (A)dd, (C)hange, or (R)emove a car? \nView the list by (M)ake, M(O)del, (Y)ear, or (P)rice?");
			System.out.println("Enter the line number to see a car individually.");
			System.out.println("You can also e(X)it.");
			response = scan.nextLine().charAt(0);
			response = Character.toLowerCase(response);

			switch (response) {
			case 'a':
				populateCarList(carList, scan);
				break;
			case 'c':
				changeCar(carList, scan);
				clearScreen();
				showCars(carList);
				break;
			case 'r':
				removeCar(carList, scan);
				clearScreen();
				showCars(carList);
				break;
			case 'm':
				Collections.sort(carList, new CompareMake());
				clearScreen();
				showCars(carList);
				break;
			case 'o':
				Collections.sort(carList, new CompareModel());
				clearScreen();
				showCars(carList);
				break;
			case 'y':
				Collections.sort(carList, new CompareYear());
				clearScreen();
				showCars(carList);
				break;
			case 'p':
				Collections.sort(carList, new ComparePrice());
				clearScreen();
				showCars(carList);
				break;
			case 'i':
				importCars(carList);
				clearScreen();
				showCars(carList);
				break;
			case 'x':
				// Returns to main
				break;
			default:
				if (Character.isDigit(response)) {
					int num = Character.getNumericValue(response);
					if (carList.size() > 9) {
						Validator.getInt(scan, "We're having technical difficulties.\nPlease re-enter your numeric selection.", 1, carList.size());
					}
					// Display car in another format
					Car.showCar(carList.get(num-1), num);
					System.out.println();
					Validator.getChar(scan, "Hit Enter to return to menu.");
				}	
				else {
					System.out.println();
					Validator.getChar(scan, "Invalid Choice. Hit Enter to return to menu.");
					
				}
				clearScreen();
				showCars(carList);
				break;
			}

		}

	}

	public static void populateCarList(ArrayList<Car> carList, Scanner scan) {
		char cont = 'y';
		while (cont == 'y') {
			int i = carList.size()+1;
			addCar(carList, i, scan);
			clearScreen();
			showCars(carList);
			cont = Validator.getChar(scan, "Would you like to add another? (y/n)");
		}
		clearScreen();
		showCars(carList);
	}

	public static void addCar(ArrayList<Car> carList, int num, Scanner scan) {
		String status = "new";
		String prompt;
		do {
			prompt = String.format("Is Car #%d New or Used? ", num);
			status = Validator.getString(scan, prompt, 'a');
		} while (!status.equalsIgnoreCase("new") && !status.equalsIgnoreCase("used"));

		prompt = String.format("What is the Make of Car #%d? ", num);
		String make = Validator.getString(scan, prompt);

		prompt = String.format("What is the Model of Car #%d? ", num);
		String model = Validator.getString(scan, prompt);

		prompt = String.format("What is the Year of Car #%d? ", num);
		int year = Validator.getInt(scan, prompt);

		prompt = String.format("What is the Price of Car #%d? ", num);
		double price = Validator.getDouble(scan, prompt);

		//
		if (status.equalsIgnoreCase("new")) {
			// Add NewCar Object to ArrayList
			carList.add(new NewCar(make, model, year, price));

		} else {
			prompt = String.format("What is Car #%d's Mileage? ", num);
			double mileage = Validator.getDouble(scan, prompt);
			// Add UsedCar Object to ArrayList
			carList.add(new UsedCar(make, model, year, price, mileage));
		}

	}

	public static void showCars(ArrayList<Car> carList) {
		System.out.println(
				String.format("   %-10s %-18s %4s    %-12s   %-13s", "Make", "Model", "Year", "Price", "Mileage"));
		System.out.println("   _______________________________________________________________");
		for (int i = 0; i < carList.size(); i++) {
			System.out.println((i + 1) + "  " + carList.get(i).toString());
		}
	}

	public static void removeCar(ArrayList<Car> carList, Scanner scan) {
		System.out.println();
		int removedCar = Validator.getInt(scan, "Which car would you like to remove? \n Enter Line Number.", 1,
				carList.size());
		char confirm = Validator.getChar(scan, "Are you sure? (y/n)");
		if (confirm == 'y') {
			carList.remove((removedCar - 1));
		}
	}

	public static void changeCar(ArrayList<Car> carList, Scanner scan) {
		String status = "new";
		String prompt;
		
		// Ask which car to change
		int num = Validator.getInt(scan, "Which vehicle would you like to change? ", 1, carList.size());
			
		prompt = String.format("Is Car #%d New or Used? ", num);
		status = Validator.getString(scan, prompt, 'a');
	while (!status.equalsIgnoreCase("new") && !status.equalsIgnoreCase("used"));

	prompt = String.format("What is the Make of Car #%d? ", num);
	String make = Validator.getString(scan, prompt);

	prompt = String.format("What is the Model of Car #%d? ", num);
	String model = Validator.getString(scan, prompt);

	prompt = String.format("What is the Year of Car #%d? ", num);
	int year = Validator.getInt(scan, prompt);

	prompt = String.format("What is the Price of Car #%d? ", num);
	double price = Validator.getDouble(scan, prompt);

	// Change Entry
	int pos = num -1;
	
	if (status.equalsIgnoreCase("new")) {
		// Change NewCar Object in ArrayList
		carList.get(pos).setMake(make);
		carList.get(pos).setModel(model);
		carList.get(pos).setYear(year);
		carList.get(pos).setPrice(price);

	} else {
		prompt = String.format("What is Car #%d's Mileage? ", num);
		double mileage = Validator.getDouble(scan, prompt);
		// Change UsedCar Object in ArrayList
				carList.get(pos).setMake(make);
				carList.get(pos).setModel(model);
				carList.get(pos).setYear(year);
				carList.get(pos).setPrice(price);
				carList.get(pos).setMileage(mileage);
	}

		
		
	}
	
	public static void clearScreen() {
		// Move text off screen to redraw chart
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}

	}

	public static void importCars(ArrayList<Car> carList) {
		// Save some time
		carList.add(new UsedCar("Pontiac", "Bonneville" , 1994, 500, 212000));
		carList.add(new UsedCar("Chevrolet", "Trailblazer", 2002, 2500, 178999));
		carList.add(new UsedCar("Plymouth", "Voyager", 1988, 500, 186743));
		carList.add(new UsedCar("Chevrolet", "Celebrity Eurosport", 1984, 500, 165732));
		carList.add(new NewCar("Ford", "F-150", 2018, 64222));
		carList.add(new NewCar("Lincoln", "Navigator", 2017, 73032));
		carList.add(new NewCar("Honda", "Civic", 2017, 28556));
		carList.add(new NewCar("Toyota", "Prius", 2018, 39773));
		
	}
}
