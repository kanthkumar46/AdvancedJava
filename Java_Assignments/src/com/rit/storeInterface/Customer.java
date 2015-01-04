package com.rit.storeInterface;
/* 
 * Customer.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */

/**
 * Class provides the methods to return cart and bag objects
 * to customer.
 * 
 * @author      Kanth
 * @author      Suman
 */


class Customer{
	private int cart_count = 0;
	
	/**
	 * Creates and returns the new cart object; Maximum of two
	 * 
	 */
	
	public Cart getCart() {
		if(cart_count <= 2){
			cart_count++;
			return new Cart();
		}
		else 
			return null;
	}
	
	/**
	 * Creates and returns the new cart object; Maximum of two
	 * 
	 */
	
	public Bag getBag() {
		return new Bag();
	}
	
	/**
	 * call the method to generate bill and prints out the
	 * total of items
	 * 
	 */
	
	public void checkout(){
		Cashier cashier = new Cashier();
		cashier.genrateBill();
		double total = cashier.computeCost();
		System.out.println("__________________");
		System.out.println("cost   : "+total);
		
	}
	
}