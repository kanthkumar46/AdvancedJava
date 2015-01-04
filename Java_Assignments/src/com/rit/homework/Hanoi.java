package com.rit.homework;

/* 
 * Hanoi.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */

/**
 * This program solves the tower of hanoi problem for the 
 * give number of discs 
 *
 * @author      Kanth
 * @author      Suman
 */

public class Hanoi {

	static int [][] pegs = new int[10][10];  //2D array to show the discs movement 
    static int no_of_disks;                  // number of disks 
    
    /**
	 * The main program.
	 *
	 * @param    args    command line arguments
	 */
    
	public static void main(String[] args) {
		no_of_disks = Integer.parseInt(args[0]);
		int n = no_of_disks;
		
		// Array initialization that shows initial disks setup.
		for (int i=0;i<no_of_disks;i++)
	    	for(int j=0;j<3;j++){
	    		if(j==0)
	    			pegs[i][j]=i+1;
	    		else
	    			pegs[i][j]=0;
	    	}
		
		for (int i=0;i<no_of_disks;i++){
	    	for(int j=0;j<3;j++){
	    		System.out.print(pegs[i][j] + "  ");
	    	}
	    	System.out.println();
		}
		System.out.println("-------");
		System.out.println("0  1  2");
		

		move(n,"0","1","2");
	}
	
	/**
	 * Recursive function to move the disks from start peg to end peg.
	 * 
	 * @param    n            number of disks
	 * @param    poleStart    start peg
	 * @param    poleOver     intermediate peg
	 * @param    poleEnd      end peg
	 */
	
	static void move(int  n, String poleStart, String poleOver, String poleEnd) {
		if(n==1){
			System.out.println("move disc"+n+" from "+poleStart+" to "+poleEnd+"\n");
			updateArray(n,poleStart,poleEnd);
			return;
		}
		
		move(n-1,poleStart,poleEnd,poleOver);
		System.out.println("move disc"+n+" from "+poleStart+" to "+poleEnd+"\n");
		updateArray(n,poleStart,poleEnd);
		move(n-1,poleOver,poleStart,poleEnd);
	}
	
	/**
	 * Function shows the disks movement by printing the array each time
	 * array is  updated
	 * 
	 * @param    n            number of disks
	 * @param    poleStart    start peg
	 * @param    poleEnd      end peg
	 */
	
	static void updateArray(int n,String poleStart,String poleEnd){
		int start, end;
		
		start = Integer.parseInt(poleStart);
		end = Integer.parseInt(poleEnd);
		
		//Array is updated before disk is moved to destination.
		
		for(int i=0;i<no_of_disks;i++){
			if(pegs[i][start] == n){
				pegs[i][start] = 0;
				break;
			}
		}
		
		//Array is updated after disk is moved to destination.
		
		for(int i=no_of_disks-1;i>=0;i--){
			if(pegs[i][end] == 0){
				pegs[i][end] = n;
				break;
			}
		}
		
		//Prints the updated array.
		
		for (int i=0;i<no_of_disks;i++){
	    	for(int j=0;j<3;j++){
	    		System.out.print(pegs[i][j] + "  ");
	    	}
	    	System.out.println();
		}
		System.out.println("-------");
		System.out.println("0  1  2");
	}
	
}
