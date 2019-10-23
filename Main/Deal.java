/**
* Deal.java
* 
* Class for Deal objects.
* 
* @author Daniel Whiteman
*
*/

public class Deal{
	
	//Declaring instance variables
	private Item item;
	private double itemPrice;
	private int dealQuantity;
	private double dealPrice;
	
	/**
     * Access method for item
     *
     * @return item Item object involved in the deal
     * 
     * @author Daniel Whiteman
     */
	public Item getItem() {return item;}
	
	/**
     * Access method for itemPrice
     *
     * @return itemPrice Price of the item individually
     * 
     * @author Daniel Whiteman
     */
	public double getItemPrice() {return itemPrice;}
	
	/**
     * Access method for dealQuantity
     *
     * @return dealQuantity Amount of units in the deal
     * 
     * @author Daniel Whiteman
     */
	public int getDealQuantity() {return dealQuantity;}
	
	/**
     * Access method for dealPrice
     *
     * @return dealPrice Price of the deal
     * 
     * @author Daniel Whiteman
     */
	public double getDealPrice() {return dealPrice;}

	/**
	 * Constructor
	 * 
	 * Instantiates a Deal object
	 * 
	 * @param i Item object
	 * @param ip Price of the item individually
	 * @param dq Amount of items in the deal
	 * @param dp Price of the deal
	 * 
	 * @author Daniel Whiteman
	 * */
	public Deal(Item i, double ip, int dq, double dp){
		item = i;
		itemPrice = ip;
		dealQuantity = dq;
		dealPrice = dp;
	}
}