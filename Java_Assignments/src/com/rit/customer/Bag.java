package com.rit.customer;
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

class Bag{
	Item item;
	int item_count = 0;
	
	/**
	 * Method to add item of some count to a bag
	 * 
	 * @param 	type 	name of item
	 * @param	count   item count	
	 */
	
	void addItemsToBag(String type,int count){
		item = new Item(type);
		item_count = count;
	}
}
