package Main;

import java.util.ArrayList;

public class Item{
	
	private String name;
	
	public Item(String n) {
		name = n;
	}
	
	public void setName(String n){name = n;}	
	public String getName(){return name;}	
	
	public static double getPrice(String name, ArrayList<Deal> pricings) {
		return (Item.getDeal(name, pricings)).getItemPrice();
	}
	
	public static int getDealQuantity(String name, ArrayList<Deal> pricings) {
		return (Item.getDeal(name, pricings)).getDealQuantity();
	}
	
	public static double getDealPrice(String name, ArrayList<Deal> pricings) {
		return (Item.getDeal(name, pricings)).getDealPrice();
	}
	
	public static Deal getDeal(String name, ArrayList<Deal> pricings) {
		for(Deal deal : pricings) {
			if (deal.getItem().getName() == name) {
				return deal;
			}
		}
		return null;
	}
}