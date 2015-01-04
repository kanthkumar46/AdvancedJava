package com.rit.storeAbstract;
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

class Cart extends Item{
	static Object[] itemList = new Object[100];  // stores all the items in Cart
	static int itemCount = 0;		//total no of items in Cart
	
	/**
	 * Abstract method of Item overridden to add any type of 
	 * item to cart; either Bag or Individual item.
	 *  
	 * 
	 * @param    itemType    type of the item
	 * @param	 count 		number of items
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
