package com.rit.storeAbstract;


/**
 * Initializes the item type and cost of each item type object
 * 
 * @author      Kanth
 * @author      Suman
 */

class IndividualItem extends Item{
	double cost;  //stores the cost of individual item
	
	/**
	 * Method overridden defined in abstract class Item
	 * 
	 * @param 	type 	type of the item.	
	 */
	
	@Override
	public void setItemType(String type) {
		itemType = type;
		cost =  PriceList.getPrice(itemType); //Sets the price of an item.
	}

	@Override
	public void addItems(Object type, int count) {
		// TODO Auto-generated method stub
	}

}
