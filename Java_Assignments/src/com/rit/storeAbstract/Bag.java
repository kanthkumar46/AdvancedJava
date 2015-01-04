package com.rit.storeAbstract;
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

class Bag extends Item{
	int itemCount = 0;	// stores item count in bag.
	double cost = 0;    // store the cost of items in bag

	/**
	 * Abstract method of Item class overridden to add Individual 
	 * item  types to Bag.
	 *  
	 * 
	 * @param    itemType    type of the item
	 * @param	 count 		number of items
	 */
	
	@Override
	public void addItems(Object type, int count) {
		// default method to set the item type defined in Abstract class Item
		setItemType(type.toString());
		cost =  count * PriceList.getPrice(itemType); //Sets the price of an item.
		itemCount = count;
	}
}
