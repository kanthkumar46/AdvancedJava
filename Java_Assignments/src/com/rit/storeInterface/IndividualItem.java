package com.rit.storeInterface;


/**
 * Initializes the item type and cost of each item type object
 * 
 * @author      Kanth
 * @author      Suman
 */

class IndividualItem implements Item{
	String itemType;
	double cost;

	/**
	 * Method setItemType of Interface Item implemented to set 
	 * individual item type and cost of individual item. 
	 *
	 * @param    type    item name
	 */
	
	@Override
	public void setItemType(String type) {
		itemType = type;
		cost =  PriceList.getPrice(itemType); //Sets the price of an item.
	}

}
