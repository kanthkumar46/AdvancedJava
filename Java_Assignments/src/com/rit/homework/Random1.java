package com.rit.homework;
/* 
 * Random1.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This program generates 1000 random numbers without any duplication
 * of numbers. The numbers are ordered using their natural ordering
 *
 * @author      Kanth
 * @author 		Suman
 */

public class Random1 {

	/**
	 * The main program.
	 *
	 * @param    args    command line arguments
	 */
	
	public static void main(String[] args) {
		// stores the random numbers generated
		SortedSet<Integer> randomNumbers = new TreeSet<Integer>();
		// call to function that generate 1000 random numbers
		randomNumbers = genearteRandomNumbers(5000);
		// prints the sorted random numbers.
		System.out.println(randomNumbers);
	}


	/**
	 * Static function that generates 1000 random numbers and
	 * adds it to the SortedSet collection type.
	 * 
	 * @param	bound	max bound for random number
	 */
	
	static SortedSet<Integer> genearteRandomNumbers(int bound){
		SortedSet<Integer> randomList = new TreeSet<Integer>();
		Random randomNo = new Random();    // random object is created
		while(randomList.size() != 1000){  // executes till 1000 different numbers are added
			int num = randomNo.nextInt(bound);
			randomList.add(num);
		}
		
	   return randomList;
	}
}
