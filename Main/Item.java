package Main;

import java.util.ArrayList;

public class Item{
	
	//Declaring the instance variable
	private String name;
	
	//Constructor
	public Item(String n) {
		name = n;
	}
	
	//Method to access the name attribute
	public String getName(){return name;}	
	
	//Method to access the price of an item using the pricing rules
	public static double getPrice(String name, ArrayList<Deal> pricings) {
		return (Item.getDeal(name, pricings)).getItemPrice();
	}
	
	//Method to access the deal quantity of an item using the pricing rules
	public static int getDealQuantity(String name, ArrayList<Deal> pricings) {
		return (Item.getDeal(name, pricings)).getDealQuantity();
	}
	
	//Method to access the deal price of an item using the pricing rules
	public static double getDealPrice(String name, ArrayList<Deal> pricings) {
		return (Item.getDeal(name, pricings)).getDealPrice();
	}
	
	//Method to find the deal that matches the name of the item from the pricing rules
	public static Deal getDeal(String name, ArrayList<Deal> pricings) {
		for(Deal deal : pricings) {
			if (deal.getItem().getName() == name) {
				return deal;
			}
		}
		return null;
	}
}