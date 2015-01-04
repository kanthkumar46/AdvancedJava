package com.rit.storeAbstract;

/**
 * Abstract Class provides default method to compute the
 * total cost of individual items
 * 
 * @author      Kanth
 * @author      Suman
 */

public abstract class CostCalculator {
	/**
	 * Method computes the total cost for individual item types
	 * that is present in the itemList (items added to carts). 
	 * 
	 * @param 	itemList	total list of items.	
	 */
	public  double[] computeItemsCost(Object[] itemlist) {
		//store the total cost of individual items
		double[] itemCost = new double[5];
		
		for(Object item:itemlist){
			//checks if item list is completely explored 
			
			if(item == null)
				break;
			
			//checks if item is an instance of single Item type.
			
			if(item instanceof IndividualItem){
				if(((IndividualItem) item).itemType.equals("apple"))
					itemCost[0] = itemCost[0] + ((IndividualItem) item).cost;
				else if(((IndividualItem) item).itemType.equals("flour"))
					itemCost[1] = itemCost[1] + ((IndividualItem) item).cost;
				else if(((IndividualItem) item).itemType.equals("kiwi"))
					itemCost[2] = itemCost[2] + ((IndividualItem) item).cost;
				else if(((IndividualItem) item).itemType.equals("orange"))
					itemCost[3] = itemCost[3] + ((IndividualItem) item).cost;
				else
					itemCost[4] = itemCost[4] + ((IndividualItem) item).cost;
			}
			
			//checks if the item is an instance of bag having particular Item type.
			
			else if(item instanceof Bag){
				if(((Bag) item).itemType.equals("apple"))
					itemCost[0] = itemCost[0] + ((Bag) item).cost;
				else if(((Bag) item).itemType.equals("flour"))
					itemCost[1] = itemCost[1] + ((Bag) item).cost;
				else if(((Bag) item).itemType.equals("kiwi"))
					itemCost[2] = itemCost[2] + ((Bag) item).cost;
				else if(((Bag) item).itemType.equals("orange"))
					itemCost[3] = itemCost[3] + ((Bag) item).cost;
				else
					itemCost[4] = itemCost[4] + ((Bag) item).cost;
			}
		}
		return itemCost;
	}
}
