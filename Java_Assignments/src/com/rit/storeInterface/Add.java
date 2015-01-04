package com.rit.storeInterface;

/**
 * Interface Add; provides method signature to add the items of given count.
 * method will be defined in the classes implementing this interface
 * 
 * @author      Kanth
 * @author      Suman
 */

public interface Add {
	/**
	 * method to add the item of given type and count
	 * 
	 * @param 	type 	type of the item.	
	 */
	public void addItems(Object type, int count);
}
