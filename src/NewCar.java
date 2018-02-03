import java.util.Scanner;

public class NewCar extends Car {

	// Constructors
	public void NewCar() {
		
	}
	
	public NewCar(String make, String model, int year, double price) {
		super.make = make;
		super.model = model;
		super.year = year;
		super.price = price;
	}

// Functional Methods

	public String toString(String make, String model, int year, double price) {
		String printString = String.format("%-10s %-10s %-10d $%,8.2f", make, model, year, price);
		return printString;
	}
	
	public String toString() {
		String printString = String.format("%-10s %-10s %-10d $%,8.2f", make, model, year, price);
		return printString;
	}
	
	public static void showCar(NewCar car, int num) {
		CarSalesApp.clearScreen();
		System.out.println("Car #" + num);
		System.out.println(car.getYear() + " " + car.getMake() + " " + car.getModel());
		System.out.println("$" + car.getPrice());
		
	}




}
