package com.rit.customer;


/**
 * Initializes the item type and cost of each item type object
 * 
 * @author      Kanth
 * @author      Suman
 */

class Item{
	String itemType;
	double cost;

	/**
	 * Constructor-Initializes name of item and its cost.
	 *
	 * @param    type    item name
	 */
	
	Item(String type){
		itemType = type;
		cost =  PriceList.getPrice(itemType); //Sets the price of an item. 
	}
}
