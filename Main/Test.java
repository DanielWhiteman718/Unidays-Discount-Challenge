/**
* Main.java
* 
* Main class
* 
* @author Daniel Whiteman
*
*/

import java.util.ArrayList;

public class Test{
	
	public static void main(String[] args){
		//Declares the pricingRules by building a list of Deals
		ArrayList<Deal> pricingRules = new ArrayList<Deal>();
		pricingRules.add(new Deal(new Item("A"), 8.00, 0, 0.00));
		pricingRules.add(new Deal(new Item("B"), 12.00, 2, 20.00));
		pricingRules.add(new Deal(new Item("C"), 4.00, 3, 10.00));
		pricingRules.add(new Deal(new Item("D"), 7.00, 2, 7.00));
		pricingRules.add(new Deal(new Item("E"), 5.00, 3, 10.00));
		
		//Initiales the UnidaysDiscountChallenge class with the pricingRules
		UnidaysDiscountChallenge challenge = new UnidaysDiscountChallenge(pricingRules);
		
		//Test case
		challenge.AddToBasket(new Item("E"));
		challenge.AddToBasket(new Item("D"));
		challenge.AddToBasket(new Item("C"));
		challenge.AddToBasket(new Item("B"));
		challenge.AddToBasket(new Item("A"));
		challenge.AddToBasket(new Item("E"));
		challenge.AddToBasket(new Item("D"));
		challenge.AddToBasket(new Item("C"));
		challenge.AddToBasket(new Item("B"));
		challenge.AddToBasket(new Item("C"));
		challenge.CalculateTotalPrice(challenge.getBasket(), challenge.getPricingRules());
		
		System.out.println("Basket total £"+String.format("%.2f", challenge.getTotalPrice()));
		System.out.println("Delivery cost £"+String.format("%.2f", challenge.getDeliveryCost()));
		System.out.println("Total cost £"+String.format("%.2f", (challenge.getDeliveryCost()+challenge.getTotalPrice())));


	}
}