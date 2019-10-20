package Main;

import java.util.ArrayList;

public class UnidaysDiscountChallenge{
	
	
	private ArrayList<Item> basket;
	private double totalPrice;
	private ArrayList<Deal> pricingRules;
	private double deliveryCost;
	
	public UnidaysDiscountChallenge(ArrayList<Deal> pr){
		basket = new ArrayList<Item>();
		totalPrice = 0;
		pricingRules = pr;
		deliveryCost = 0;
	}
	
	public ArrayList<Item> getBasket(){return basket;}
	public double getTotalPrice() {return totalPrice;}
	public ArrayList<Deal> getPricingRules(){return pricingRules;}
	public double getDeliveryCost(){return deliveryCost;}
	
	public void AddToBasket(Item item) {
		basket.add(item);
	}
	
	public void CalculateTotalPrice(ArrayList<Item> basket, ArrayList<Deal> pricingRules) {
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
		
		
		totalPrice = totalPrice + (itemAmounts[0] * Item.getPrice("A", pricingRules)
								+ (getDiscountPrice(itemAmounts[1], Item.getPrice("B", pricingRules), 
								  Item.getDealQuantity("B", pricingRules), Item.getDealPrice("B", pricingRules)))
								+ (getDiscountPrice(itemAmounts[2], Item.getPrice("C", pricingRules), 
								  Item.getDealQuantity("C", pricingRules), Item.getDealPrice("C", pricingRules)))
								+ (getDiscountPrice(itemAmounts[3], Item.getPrice("D", pricingRules), 
								  Item.getDealQuantity("D", pricingRules), Item.getDealPrice("D", pricingRules)))
								+ (getDiscountPrice(itemAmounts[4], Item.getPrice("E", pricingRules), 
								  Item.getDealQuantity("E", pricingRules), Item.getDealPrice("E", pricingRules))));
		System.out.println("Basket total £"+totalPrice);
		
		if (totalPrice > 49) {
			deliveryCost = 0.00;
		} else {
			deliveryCost = 7.00;
		}
		System.out.println("Delivery cost £"+deliveryCost);
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