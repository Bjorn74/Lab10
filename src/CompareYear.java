import java.util.Comparator;

public class CompareYear implements Comparator<Car> { 
	   
	public int compare(Car c1, Car c2) { 
	      return Double.compare(c1.getYear(), c2.getYear()); 
	   }


	} 
