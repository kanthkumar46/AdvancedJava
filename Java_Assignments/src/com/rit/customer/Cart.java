package com.rit.customer;
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

class Cart{
	static Object[] itemList = new Object[100];
	static int itemCount = 0;
	
	/**
	 * Function to add an item into cart
	 * 
	 * @param    itemType    name of an item
	 */
	
	void addItems(String itemType){
		Item item = new Item(itemType);
		itemList[itemCount++] = item;   //add items to list and increments the counter 
	}
	
	/**
	 * Function to add a Bag of particular item to cart 
	 * 
	 * @param    bag    Object of type bag 
	 */
	void addBag(Bag bag){
		itemList[itemCount++] = bag;   //add bag to list and increments the counter 
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
