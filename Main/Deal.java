package Main;

public class Deal{
	
	//Declaring instance variables
	private Item item;
	private double itemPrice;
	private int dealQuantity;
	private double dealPrice;
	
	//Methods to access the instance variables
	public Item getItem() {return item;}
	public double getItemPrice() {return itemPrice;}
	public int getDealQuantity() {return dealQuantity;}
	public double getDealPrice() {return dealPrice;}

	//Constructor
	public Deal(Item i, double ip, int dq, double dp){
		item = i;
		itemPrice = ip;
		dealQuantity = dq;
		dealPrice = dp;
	}
}