import java.util.ArrayList;

public class Car {
	
	// Instance Variables
	String make;
	String model;
	int year;
	double price;
	
	// Constructor Methods (overloaded)
	public void Car() {
		
	}
	
	public void Car(String make, String model, int year, double price) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;		
	}

	
	// Getter / Setter Methods
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	// Functional Methods
	public String toString(String make, String model, int year, double price) {
		String printString = String.format("%-10s %-18s %-6d $%,-9.2f", make, model, year, price);
		return printString;
	}
	
	public String toString(Car car) {
		String printString = String.format("%-10s %-18s %-6d  $%,9.2f", car.getMake(), car.getModel(), car.getYear(), car.getPrice());
		return printString;
	}
	
	public static void showCar(Car car, int num) {
		// This is here to be overridden.
		CarSalesApp.clearScreen();
		System.out.println("Car #" + num);
		System.out.println(car.getYear() + " " + car.getMake() + " " + car.getModel());
		System.out.println("$" + car.getPrice());
		
	}

	public void setMileage(double mileage) {
		// TODO Auto-generated method stub
		
	}

}
