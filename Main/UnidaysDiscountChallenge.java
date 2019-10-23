/**
* UnidaysDiscountChallenge.java
* 
* @author Daniel Whiteman
*
*/

package Main;
import java.util.ArrayList;

public class UnidaysDiscountChallenge{
	
	//Declaring instance variables
	private ArrayList<Item> basket;
	private double totalPrice;
	private ArrayList<Deal> pricingRules;
	private double deliveryCost;
	
	/**
	 * Constructor
	 * 
	 * Instantiates a Deal object
	 * 
	 * @param pr Pricing rules
	 * 
	 * @author Daniel Whiteman
	 * */
	public UnidaysDiscountChallenge(ArrayList<Deal> pr){
		basket = new ArrayList<Item>();
		totalPrice = 0;
		pricingRules = pr;
		deliveryCost = 0;
	}
	
	/**
     * Access method for basket
     *
     * @return basket, ArrayList<Item>
     * 
     * @author Daniel Whiteman
     */
	public ArrayList<Item> getBasket(){return basket;}
	
	/**
     * Access method for totalPrice
     *
     * @return totalPrice, total price of the basket(not including delivery charge)
     * 
     * @author Daniel Whiteman
     */
	public double getTotalPrice() {return totalPrice;}
	
	/**
     * Access method for pricingRules
     *
     * @return pricingRules, ArrayList<Deal> to specify prices and deals
     * 
     * @author Daniel Whiteman
     */
	public ArrayList<Deal> getPricingRules(){return pricingRules;}
	
	/**
     * Access method for deliveryCost
     *
     * @return deliveryCost, charge for delivery of items
     * 
     * @author Daniel Whiteman
     */
	public double getDeliveryCost(){return deliveryCost;}
	
	
	/**
     * AddToBasket method - Takes item and adds it to the basket
     * 
     * @param item Item object to be added to basket
     * 
     * @author Daniel Whiteman
     */
	public void AddToBasket(Item item) {
		//Adding item to basket
		basket.add(item);
	}
	
	
	/**
     * CalculateTotalPrice method - Calculates cost of basket and the delivery charge
     * 
     * @param basket ArrayList<Item> to represent the basket of items
     * @param pricingRules ArrayList<Deal> to represent deals and prices
     * 
     * @author Daniel Whiteman
     */
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
		
		//Calculates and prints the delivery cost
		if (totalPrice > 49) {
			deliveryCost = 0.00;
		} else {
			deliveryCost = 7.00;
		}
		
	}
	
	
	/**
     * getDiscountPrice - Applies discounts to an amount of items, if applicable, and returns the price
     *
     * @param quantity Amount of the item
     * @param indivPrice Price of the item individually
     * @param dealQuantity Amount of units in the deal
     * @param dealPrice Price of the deal
     * 
     * @return price Price for the amount of the specified item
     * 
     * @author Daniel Whiteman
     */
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