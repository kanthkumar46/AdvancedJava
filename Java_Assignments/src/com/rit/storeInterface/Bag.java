package com.rit.storeInterface;
/* 
 * Bag.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */

/**
 * Class provides the method to add an item to bag
 * 
 * @author      Kanth
 * @author      Suman
 */

class Bag implements Item,Add{
	String itemType;
	int itemCount = 0;
	double cost = 0;

	/**
	 * Function implemented from Item to set item type 
	 * added to the bag.
	 * 
	 * @param    itemType    type of item
	 */
	
	@Override
	public void setItemType(String type) {
		itemType = type;
	}

	/**
	 * Function implemented from Add to add an item of 
	 * given count to bag.
	 * 
	 * @param    itemType    name of an item
	 * @param	 count 		 item count
	 */
	
	@Override
	public void addItems(Object type, int count) {
		setItemType(type.toString());
		cost =  count * PriceList.getPrice(itemType); //Sets the price of an item.
		itemCount = count;
	}
}
