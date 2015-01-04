package com.rit.homework;
/* 
 * Combination.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */

import java.util.ArrayList;

/**
 * This program prints all possible combinations 
 * for a given set of elements.
 *
 * @author      Kanth
 * @author      Suman
 */

public class Combination
{
	/**
	 * The main program.
	 *
	 * @param    args    command line arguments
	 */
	
	public static void main (String[] args) 
	{
		// Create set object of N elements
		Set s = new Set(3);
		
		// Print all possible Combinations
		s.printSubsets();
	}
	
}


/**
 * Initialize the number of elements and prints
 * all possible combinations.
 *
 * @author      Kanth
 * @author      Suman
 */

class Set {
	private int n;  // number of elements
	
	/**
	 * Constructor-Initialize number of elements.
	 *
	 * @param    k    number of elements
	 */
	
	Set(int k){
		n = k;
	}
	
	/**
	 * function to print all possible combinations
	 *
	 */
	
	void printSubsets(){
		String[] elements = {"a","b","c","d","e"};  // elements in a set 
		
		int count =1;
		for(int i=0;i<n;i++){
			count = count * 2;    //number of possible combinations
		}
		
		//list to store all the combinations
		
		ArrayList<String> subSets = new ArrayList<String>(); 
		do{
    		String temp = "{";
    		for(int i=0; i<n; i++){
        		int bitvalue = count-1 & (1 << i);
        		if(bitvalue > 0)
            	temp = temp + elements[i];
    		}
    		temp=temp+"}";
    		subSets.add(temp);
    		count--;
		}while(count>0);
		
		//print out all combinations stored in the list
		
		System.out.println(subSets);  
		System.out.println("subset size is:"+subSets.size());
	}
}