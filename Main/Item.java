package Main;

public class Item{
	
	private String name;
	private double price;
	
	public Item(String n, double p) {
		name = n;
		price = p;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public String getName(){
		return name;
	}
	
	public void setPrice(double p) {
		price = p;
	}
	
	public double getPrice(){
		return price;
	}
	
	public static double getPrice(String name) {
		switch (name) {
			case "A":
				return 8.00;
			case "B":
				return 12.00;
			case "C":
				return 4.00;
			case "D":
				return 7.00;
			case "E":
				return 5.00;
		    default:
		    	return 0.0;
		}
	}
}