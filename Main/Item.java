/**
* Item.java
* 
* Class for Item object
* 
* @author Daniel Whiteman
*
*/

import java.util.ArrayList;

public class Item{
	
	//Declaring the instance variable
	private String name;
	
	
	/**
	 * Constructor
	 * 
	 * Instantiates an Item object
	 * 
	 * @param n Name of the item
	 * 
	 * @author Daniel Whiteman
	 * */
	public Item(String n) {
		name = n;
	}
	
	/**
     * Access method for name
     *
     * @return name Name of the item
     * 
     * @author Daniel Whiteman
     */	public String getName(){return name;}	
	
     /**
      * Access method for Price of the item - Uses the pricing rules to retrieve this value
      *
      * @param name Name of the item
      * @param pricings ArrayList<Deal> for pricing rules
      *
      * @return itemPrice Price of the item individually
      * 
      * @author Daniel Whiteman
      */
	public static double getPrice(String name, ArrayList<Deal> pricings) {
		return (Item.getDeal(name, pricings)).getItemPrice();
	}
	
	/**
     * Access method for the dealQuantity - Uses the pricing rules to retrieve this value
     *
     * @param name Name of the item
     * @param pricings ArrayList<Deal> for pricing rules
     *
     * @return dealQuantity Amount of units in the deal
     * 
     * @author Daniel Whiteman
     */	
	public static int getDealQuantity(String name, ArrayList<Deal> pricings) {
		return (Item.getDeal(name, pricings)).getDealQuantity();
	}
	
	/**
     * Access method for the dealPrice - Uses the pricing rules to retrieve this value
     *
     * @param name Name of the item
     * @param pricings ArrayList<Deal> for pricing rules
     *
     * @return dealPrice Price of the deal
     * 
     * @author Daniel Whiteman
     */
	public static double getDealPrice(String name, ArrayList<Deal> pricings) {
		return (Item.getDeal(name, pricings)).getDealPrice();
	}
	
	/**
     * getDeal method - From the pricing rules data structure, this method retrives
     * the deal that matches the item in question
     *
     * @param name Name of the item
     * @param pricings ArrayList<Deal> for pricing rules
     *
     * @return deal Deal object that is attached to the item
     * 
     * @author Daniel Whiteman
     */		
	public static Deal getDeal(String name, ArrayList<Deal> pricings) {
		for(Deal deal : pricings) {
			if (deal.getItem().getName() == name) {
				return deal;
			}
		}
		return null;
	}
}