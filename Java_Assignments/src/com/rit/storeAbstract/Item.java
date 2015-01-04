package com.rit.storeAbstract;

/**
 * Abstract class that provides the method to set the type of item
 * and abstract method to add items.
 * 
 * @author      Kanth
 * @author      Suman
 */

public abstract class Item {
	protected String itemType;
	
	/**
	 * Default method to set the item type.
	 * 
	 * @param 	type 	type of the item.	
	 */
	public void setItemType(String type){
			itemType = type;
	}

	/**
	 * Abstract method to add items.
	 * 
	 * @param 	type 	Object type.
	 * @param	count	items number.
	 */
	public abstract void addItems(Object type, int count);
}
