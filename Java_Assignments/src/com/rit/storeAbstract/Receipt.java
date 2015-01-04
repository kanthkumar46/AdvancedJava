package com.rit.storeAbstract;


/**
 * Class provides the method to count the total item types
 * and to print the Receipt
 * 
 * @author      Kanth
 * @author      Suman
 */

class Receipt extends CostCalculator{
	
	/**
	 * Method to print the receipt for purchased items.
	 * 
	 * @param 	itmelist 	items list in the carts	
	 */
	
	void printReceipt(Object[] itemlist){
		//Method to Compute the total items cost defined in abstract class
		double[] itemsCost = computeItemsCost(itemlist); 
		
		//prints the item, item count in the cart and total cost of it.
		
		if(itemsCost[0] >0)
			System.out.println("apple  :"+(int)(itemsCost[0]/PriceList.getPrice("apple"))
					+"  "+"("+itemsCost[0]/100+")");
		if(itemsCost[1] >0)
			System.out.println("flour  :"+(int)(itemsCost[1]/PriceList.getPrice("flour"))
					+"  "+"("+itemsCost[1]/100+")");
		if(itemsCost[2] >0)
			System.out.println("kiwi   :"+(int)(itemsCost[2]/PriceList.getPrice("kiwi"))
					+"  "+"("+itemsCost[2]/100+")");
		if(itemsCost[3] >0)
			System.out.println("orange :"+(int)(itemsCost[3]/PriceList.getPrice("orange"))
					+"  "+"("+itemsCost[3]/100+")");
		if(itemsCost[4] >0)
			System.out.println("milk   :"+(int)(itemsCost[4]/PriceList.getPrice("milk"))
					+"  "+"("+itemsCost[4]/100+")");
	}
}
