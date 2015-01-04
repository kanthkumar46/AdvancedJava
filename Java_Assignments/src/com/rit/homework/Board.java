package com.rit.homework;
/* 
 * Board.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */

/**
 * This program find the maximum number of kings that can be
 * placed for a given chess board without threatening each other.
 *
 * @author      Kanth
 * @author      Suman
 */

class Board{

	/* solution matrix that stores the positions of all kings 
	   for a given customized chess board */
	
	static int[][] soln = new int[][]{
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 2, 0, 0, 2, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			{0, 0, 0, 2, 0, 0, 2, 0, 0, 0 },		
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	};
	
	static int board_size =10;     	// size of chess board
	
	/**
	 * The main program.
	 *
	 * @param    args    command line arguments
	 */
	
	public static void main (String[] args){
		
		//  Customized chess board in form of 2D matrix
		
		int[][] m = new int[][]{
			{1, 1, 1, 1, 0, 0, 1, 1, 1, 1 },
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{1, 1, 1, 2, 1, 1, 2, 1, 1, 1 },
			{0, 1, 1, 1, 0, 0, 1, 1, 1, 0 },
			{0, 1, 1, 1, 0, 0, 1, 1, 1, 0 },
			{1, 1, 1, 2, 1, 1, 2, 1, 1, 1 },
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{1, 1, 1, 1, 0, 0, 1, 1, 1, 1 },
		};
		
		// function call to find maximum kings starting with first(0,0) position
		
		maxKings(m,0,0);  
		
		printSoln();   // prints the solution.
		
	}
	
	/**
	 * function to check if given position is safe or not
	 * to place a king.
	 * 
	 * @param    i    row
	 * @param    j    column
	 */
	
	static boolean isSafe(int i,int j){
		
		int n = board_size; // initialize board size
		
		/*checks all the boundary conditions for a given position
		 to determine if the position is safe or not */
		
		if((j-1>=0 && (soln[i][j-1]==1 || soln[i][j-1]==2)) 
				|| (j+1<n && (soln[i][j+1]==1 || soln[i][j+1]==2)))
			return false;
		else if((i-1>=0 && (soln[i-1][j]==1 || soln[i-1][j]==2)) 
				|| (i+1<n && (soln[i+1][j]==1 || soln[i+1][j]==2)))
			return false;
		else if(((j-1>=0 && i-1>=0) && (soln[i-1][j-1]==1 || soln[i-1][j-1]==2)) 
				|| ((j+1<n && i+1<n) && (soln[i+1][j+1]==1 || soln[i+1][j+1]==2)))
			return false;
		else if(((j-1>=0 && i+1<n) && (soln[i+1][j-1]==1 || soln[i+1][j-1]==2)) 
				|| ((i-1>=0 && j+1<n) && (soln[i-1][j+1]==1 || soln[i-1][j+1]==2)))
			return false;
		else if(soln[i][j]==1 || soln[i][j]==2)
			return false;
		else 
			return true;
	
	} 
	
	/**
	 * function try to place maximum number of kings recursively for
	 * a given customized chess board and updates the solution matrix.
	 * 
	 * @param    m    chess board in form of two dimensional array 
	 * @param    i    row
	 * @param    j    column
	 */
	
	static void maxKings(int[][] m,int i,int k){
		for(int j=k;j<board_size;j++){
			if(m[i][j]!=0 && isSafe(i,j)){
				soln[i][j]=1;
				if(j<board_size-1) 
					maxKings(m,i,j+1);
			}
			if(soln[i][j]==1 && j!=board_size-1){
				soln[i][j]=0;
				if(m[i][j+1]!=0 && isSafe(i,j+1)){
					soln[i][j+1]=1;
					maxKings(m,i,j+1);
				}
				else
					soln[i][j]=1;
			}
			if(i<board_size-1 && j==board_size-1)
				maxKings(m,i+1,0);
		}
	}
	
	/**
	 * function to print solution matrix and maximum number 
	 * of kings that can be placed. 
	 *
	 */
	
	static void printSoln(){
		int count = 0;
		for(int i=0;i<board_size;i++){
			for(int j=0;j<board_size;j++){
				if(soln[i][j] == 1 || soln[i][j] == 2)
					count++;
				System.out.print(soln[i][j]+" ");
			}
			System.out.println("");
		}
		
		System.out.println("Maximum kings that can be placed is: "+ count);
	}
		
}
