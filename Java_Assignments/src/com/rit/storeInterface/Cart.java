package com.rit.storeInterface;
/* 
 * Cart.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */

/**
 * Class provides the methods of add items and bag to cart;
 * also provide with a method to return item list in cart
 * 
 * @author      Kanth
 * @author      Suman
 */

class Cart implements Add{
	static Object[] itemList = new Object[100];
	static int itemCount = 0;
	
	/**
	 * Function implemented from Add to add an item or
	 * bag into cart.
	 * 
	 * @param    itemType    name of an item
	 * @param	 count 		 item count
	 */
	
	public void addItems(Object itemType, int count){
		if(itemType instanceof Bag){
			itemList[itemCount++] = itemType;
		}
		else{
			IndividualItem item = new IndividualItem();
			item.setItemType(itemType.toString());
			itemList[itemCount++] = item;   //add items to list and increments the counter 
		}
	}
	
	/**
	 * Function that return the total item list in cart
	 * 
	 * @param    itemType    name of an item
	 */
	public static Object[] getItemList(){
		return itemList;            // returns total item list
	}
}
