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
		
		/*challenge.AddToBasket(new Item("A", 8.00));
		challenge.AddToBasket(new Item("B", 12.00));
		challenge.AddToBasket(new Item("C", 4.00));
		challenge.AddToBasket(new Item("D", 7.00));
		challenge.AddToBasket(new Item("E", 5.00));*/
		
		challenge.AddToBasket(new Item("E", 5.00));
		challenge.AddToBasket(new Item("D", 7.00));
		challenge.AddToBasket(new Item("C", 4.00));
		challenge.AddToBasket(new Item("B", 12.00));
		challenge.AddToBasket(new Item("A", 8.00));
		challenge.AddToBasket(new Item("E", 5.00));
		challenge.AddToBasket(new Item("D", 7.00));
		challenge.AddToBasket(new Item("C", 4.00));
		challenge.AddToBasket(new Item("B", 12.00));
		challenge.AddToBasket(new Item("C", 4.00));

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
		totalPrice = totalPrice + (itemAmounts[0] * 8.00);
		totalPrice = totalPrice + (getDiscountPrice(itemAmounts[1], Item.getPrice("B"), 2, 20.00));
		totalPrice = totalPrice + (getDiscountPrice(itemAmounts[2], Item.getPrice("C"), 3, 10.00));
		totalPrice = totalPrice + (getDiscountPrice(itemAmounts[3], Item.getPrice("D"), 2, 7.00));
		totalPrice = totalPrice + (getDiscountPrice(itemAmounts[4], Item.getPrice("E"), 3, 10.00));
		System.out.println(totalPrice);
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