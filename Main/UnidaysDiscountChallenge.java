package Main;

import java.util.ArrayList;

public class UnidaysDiscountChallenge{
	
	//Declaring instance variables
	private ArrayList<Item> basket;
	private double totalPrice;
	private ArrayList<Deal> pricingRules;
	private double deliveryCost;
	
	//Constructor
	public UnidaysDiscountChallenge(ArrayList<Deal> pr){
		basket = new ArrayList<Item>();
		totalPrice = 0;
		pricingRules = pr;
		deliveryCost = 0;
	}
	
	//Methods to access the instance variables
	public ArrayList<Item> getBasket(){return basket;}
	public double getTotalPrice() {return totalPrice;}
	public ArrayList<Deal> getPricingRules(){return pricingRules;}
	public double getDeliveryCost(){return deliveryCost;}
	
	
	public void AddToBasket(Item item) {
		//Adding item to basket
		basket.add(item);
	}
	
	public void CalculateTotalPrice(ArrayList<Item> basket, ArrayList<Deal> pricingRules) {
		//Array to store amount of each item in the basket
		int[] itemAmounts = {0,0,0,0,0};
		
		//Iterates through the basket updates itemAmounts according to the item's name
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
		
		//Calculates and prints the total price
		totalPrice = totalPrice + (itemAmounts[0] * Item.getPrice("A", pricingRules)
								+ (getDiscountPrice(itemAmounts[1], Item.getPrice("B", pricingRules), 
								  Item.getDealQuantity("B", pricingRules), Item.getDealPrice("B", pricingRules)))
								+ (getDiscountPrice(itemAmounts[2], Item.getPrice("C", pricingRules), 
								  Item.getDealQuantity("C", pricingRules), Item.getDealPrice("C", pricingRules)))
								+ (getDiscountPrice(itemAmounts[3], Item.getPrice("D", pricingRules), 
								  Item.getDealQuantity("D", pricingRules), Item.getDealPrice("D", pricingRules)))
								+ (getDiscountPrice(itemAmounts[4], Item.getPrice("E", pricingRules), 
								  Item.getDealQuantity("E", pricingRules), Item.getDealPrice("E", pricingRules))));
		System.out.println("Basket total £"+String.format("%.2f", totalPrice));
		
		//Calculates and prints the delivery cost
		if (totalPrice > 49) {
			deliveryCost = 0.00;
		} else {
			deliveryCost = 7.00;
		}
		System.out.println("Delivery cost £"+String.format("%.2f", deliveryCost));
		
		//Calculates and prints the total cost
		System.out.println("Total cost £"+String.format("%.2f", (deliveryCost+totalPrice)));
	}
	
	
	public double getDiscountPrice(int quantity, double indivPrice, int dealQuantity, double dealPrice) {	
		double price = 0;
		//The number of items that qualify for the discount
		int discountedAmount = (int)(quantity / dealQuantity);
		
		//Adds the discounted price to price
		price = price + (discountedAmount * dealPrice);
		
		//The number of items that do not qualify for the discount
		int notDiscountedAmount = (quantity % dealQuantity);
		//Adds the discounted price to price
		price = price + (notDiscountedAmount * indivPrice);
		
		return price;
	}
	
}