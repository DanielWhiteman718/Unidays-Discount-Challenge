package Main;

import java.util.ArrayList;

public class UnidaysDiscountChallenge{
	
	private ArrayList<Item> basket;
	private double totalPrice;
	
	public UnidaysDiscountChallenge(){
		basket = new ArrayList<Item>();
	}
	
	public static void main(String[] args) {
		Item a = new Item("A", 5.6);
	}
	
	public void AddToBasket(Item item) {
		basket.add(item);
	}
}