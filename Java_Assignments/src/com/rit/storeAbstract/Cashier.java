package com.rit.storeAbstract;
/* 
 * Cashier.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */

/**
 * Class provides the methods to Compute the total cost of items
 * and the generate the receipt to a customer
 * 
 * @author      Kanth
 * @author      Suman
 */

class Cashier extends CostCalculator{
	
	/**
	 * Function to Compute the total cost items
	 * 
	 */
	
	double computeCost(){
		Object[] item_list = Cart.getItemList();
		double cost = 0;
		
		//checks if item list is exceeded more than 100.
		
		if(item_list.length>100){
			return 0;
		}
		
		//Computes the total cost of all items including bag in cart
		
		else{
			//Method to Compute the total items cost defined in abstract class.
			double[] itemsCost = computeItemsCost(item_list);
			for(int i=0;i<itemsCost.length;i++)
				cost = cost + itemsCost[i];
			return cost/100;
		}
	}
	
	/**
	 * Function to generate the Receipt or Bill.
	 * 
	 */
	
	void genrateBill(){
		Object[] item_list = Cart.getItemList();
		
		//checks if item list is exceeded more than 100.
		
		if(item_list.length>100){
			System.out.println("Cannot buy more than 100 items; Remove some items");
			return;
		}
		else{
			new Receipt().printReceipt(item_list); //Computes and prints the receipt
		}
	}
}
