package com.rit.homework;
/* 
 * Random2.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */

import java.util.HashSet;
import java.util.Random;

/**
* This program generates 1000 random numbers without any duplication
* of numbers. Generated numbers are added to HashSet to provide constant
* time performance
*
* @author		Kanth
* @author 		Suman
*/

public class Random2 {

	/**
	 * The main program.
	 *
	 * @param    args    command line arguments
	 */
	
	public static void main(String[] args) {
		// stores the random numbers generated
		HashSet<Integer> randomNumbers = new HashSet<Integer>();
		// call to function that generate 1000 random numbers
		randomNumbers = genearteRandomNumbers(5000);
		// prints the random numbers stored in Hashset
		System.out.println(randomNumbers);
	}

	/**
	 * Static function that generates 1000 random number and adds
	 * it to the HashSet collection type.
	 * 
	 * @param	bound	max bound for random number
	 */
	
	static HashSet<Integer> genearteRandomNumbers(int bound){
		HashSet<Integer> randomList = new HashSet<Integer>();
		Random randomNo = new Random();  // random object is created
		while(randomList.size() != 1000){  // executes till 1000 different numbers are added
			int num = randomNo.nextInt(bound);
			randomList.add(num);
		}
		
	   return randomList;
	}
}
