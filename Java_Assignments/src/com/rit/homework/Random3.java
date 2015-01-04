package com.rit.homework;
/* 
 * Random3.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
* This program generates 1000 random numbers; duplicate numbers are
* not ignored.Generated numbers are added to Arraylist it is then linked
* to hashtable to provide constant time performance
*
* @author		Kanth
* @author 		Suman
*/

public class Random3 {

	/**
	 * The main program.
	 *
	 * @param    args    command line arguments
	 */
	
	public static void main(String[] args) {
		// stores the 1000 random numbers having duplicates
		Hashtable<Integer, List<Integer>> mp = new Hashtable<>();

		int index = 0;
		while (index <= 1000) {   // Executes till 1000 random numbers are generated 
			Random rd = new Random();
			int number = rd.nextInt(1200);
			List<Integer> lst = null;  // list to store the duplicates.
			if (mp.containsKey(number)) {
				lst = mp.get(number);
				lst.add(number);
				mp.put(number, lst);
			} else {
				lst = new ArrayList<>();
				lst.add(number);
				mp.put(number, lst);
			}
			index++;
		}

		// prints 1000 random numbers with duplicates stores in hashmap
		System.out.println("Printing the hashmap");
		Set<Integer> keys = mp.keySet();
		for (Integer key : keys) {
			List<Integer> lst = mp.get(key);
			if (lst.size() > 1) {
				for (Integer i : lst)
					System.out.println(i + " Duplicate");
			} else {
				for (Integer i : lst)
					System.out.println(i);
			}
		}
	}

}
