package com.rit.storeInterface;


/**
 * Class provides the method to count the total item types
 * and to print the Receipt
 * 
 * @author      Kanth
 * @author      Suman
 */

class Receipt{
	
	/**
	 * Method to print the receipt for purchased items.
	 * 
	 * @param 	itmelist 	items list in the carts	
	 */
	
	void printReceipt(Object[] itemlist){
		//store the total cost of individual items
		double[] itemCount = new double[5];
		
		for(Object item:itemlist){
			//checks if item list is completely explored 
			
			if(item == null)
				break;
			
			//checks if item is an instance of single Item type.
			
			if(item instanceof IndividualItem){
				if(((IndividualItem) item).itemType.equals("apple"))
					itemCount[0] = itemCount[0] + ((IndividualItem) item).cost;
				else if(((IndividualItem) item).itemType.equals("flour"))
					itemCount[1] = itemCount[1] + ((IndividualItem) item).cost;
				else if(((IndividualItem) item).itemType.equals("kiwi"))
					itemCount[2] = itemCount[2] + ((IndividualItem) item).cost;
				else if(((IndividualItem) item).itemType.equals("orange"))
					itemCount[3] = itemCount[3] + ((IndividualItem) item).cost;
				else
					itemCount[4] = itemCount[4] + ((IndividualItem) item).cost;
			}
			
			//checks if the item is an instance of bag having particular Item type.
			
			else if(item instanceof Bag){
				if(((Bag) item).itemType.equals("apple"))
					itemCount[0] = itemCount[0] + ((Bag) item).cost;
				else if(((Bag) item).itemType.equals("flour"))
					itemCount[1] = itemCount[1] + ((Bag) item).cost;
				else if(((Bag) item).itemType.equals("kiwi"))
					itemCount[2] = itemCount[2] + ((Bag) item).cost;
				else if(((Bag) item).itemType.equals("orange"))
					itemCount[3] = itemCount[3] + ((Bag) item).cost;
				else
					itemCount[4] = itemCount[4] + ((Bag) item).cost;
			}
		}
		
		//prints the item, item count in the cart and total cost of it.
		
		if(itemCount[0] >0)
			System.out.println("apple  :"+(int)(itemCount[0]/PriceList.getPrice("apple"))
					+"  "+"("+itemCount[0]/100+")");
		if(itemCount[1] >0)
			System.out.println("flour  :"+(int)(itemCount[1]/PriceList.getPrice("flour"))
					+"  "+"("+itemCount[1]/100+")");
		if(itemCount[2] >0)
			System.out.println("kiwi   :"+(int)(itemCount[2]/PriceList.getPrice("kiwi"))
					+"  "+"("+itemCount[2]/100+")");
		if(itemCount[3] >0)
			System.out.println("orange :"+(int)(itemCount[3]/PriceList.getPrice("orange"))
					+"  "+"("+itemCount[3]/100+")");
		if(itemCount[4] >0)
			System.out.println("milk   :"+(int)(itemCount[4]/PriceList.getPrice("milk"))
					+"  "+"("+itemCount[4]/100+")");
	}
}
