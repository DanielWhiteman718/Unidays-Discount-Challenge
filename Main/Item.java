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
	
}