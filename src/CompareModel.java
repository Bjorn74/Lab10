import java.util.Comparator;

public class CompareModel implements Comparator<Car> { 
	   
	public int compare(Car c1, Car c2) { 
	      return c1.getModel().compareTo(c2.getModel()); 
	   }


	} 
