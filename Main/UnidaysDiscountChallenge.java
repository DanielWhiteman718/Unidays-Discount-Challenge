package Main;

import java.util.ArrayList;

public class UnidaysDiscountChallenge{
	
	private ArrayList<Item> basket;
	private double totalPrice;
	
	public UnidaysDiscountChallenge(){
		basket = new ArrayList<Item>();
	}
	
	public ArrayList<Item> getBasket(){
		return basket;
	}
	
	public static void main(String[] args) {
		UnidaysDiscountChallenge challenge = new UnidaysDiscountChallenge();
		Item a = new Item("A", 5.6);
		Item b = new Item("E", 5.6);

		challenge.AddToBasket(a);
		challenge.AddToBasket(b);
		challenge.CalculateTotalPrice(challenge.getBasket());
	}
	
	public void AddToBasket(Item item) {
		basket.add(item);
	}
	
	public void CalculateTotalPrice(ArrayList<Item> basket) {
		int[] itemAmounts = {0,0,0,0,0};
		
		for(Item i : basket) {
			
			String name = i.getName();
			
			switch (name) {
				case "A":
					itemAmounts[0] = itemAmounts[0] + 1;
					break;
				case "B":
					itemAmounts[1] = itemAmounts[1] + 1;
					break;
				case "C":
					itemAmounts[2] = itemAmounts[2] + 1;
					break;
				case "D":
					itemAmounts[3] = itemAmounts[3] + 1;
					break;
				case "E":
					itemAmounts[4] = itemAmounts[4] + 1;
					break;
				default:
					itemAmounts[0] = itemAmounts[0] + 1;
					break;
			}
				
		}
		for (int i : itemAmounts) {
			System.out.println(i);
		}
		
		System.out.println(this.getDiscountPrice(6, 12.00, 2, 20.00));
	}
	
	public double getDiscountPrice(int quantity, double indivPrice, int dealQuantity, double dealPrice) {
		double price = 0;
		int discountedAmount = (int)(quantity / dealQuantity);
		price = price + (discountedAmount * dealPrice);
		int notDiscountedAmount = (quantity % dealQuantity);
		price = price + (notDiscountedAmount * indivPrice);
		return price;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}