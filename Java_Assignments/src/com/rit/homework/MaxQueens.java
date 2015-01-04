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
 * This program find the maximum number of queens that can be
 * placed for a given chess board without threatening each other.
 *
 * @author      Kanth
 * @author      Suman
 */

public class MaxQueens {
	
	/* solution matrix that stores the positions of all queens 
	   that are currently placed on the chess board*/
	
	static int[][] soln = new int[8][8];
	
	static int board_size = 8;     	// size of chess board
	static int maxQueens = 0;       // variable to store maximum number of queens
	
	/* final solution matrix representing the positions of maximum
	 number of queens that can be placed on the chess board*/
	
	static int[][] finalSoln = new int[8][8]; 
	
	/**
	 * The main program.
	 *
	 * @param    args    command line arguments
	 */
	
	public static void main (String[] args){
		
		/*2D matrix representing vertical walls in 
		  the chess board*/
		
		int[][] vwall = new int[][]{
			{0, 0, 0, 0, 0, 0, 1, 0},
			{0, 0, 0, 0, 1, 0, 1, 0},
			{0, 0, 0, 0, 1, 0, 0, 0},
			{0, 0, 0, 0, 0, 1, 0, 0},
			{0, 0, 1, 0, 0, 1, 0, 0},
			{0, 0, 1, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0},
			{0, 1, 0, 0, 0, 0, 1, 0}			
		};
		
		/*2D matrix representing horizontal walls in 
		  the chess board*/
		
		int[][] hwall = new int[][]{
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{1, 1, 1, 0, 0, 0, 0, 0},
				{0, 0, 0, 1, 1, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 1, 1, 1},
				{0, 0, 1, 1, 1, 0, 0, 0},
				{1, 0, 0, 0, 0, 0, 0, 0}
			};
		
		// function call to find maximum queens starting with first(0,0) position
		
		maxQueens(vwall,hwall,0,0);  
		
		printSoln();   // prints the solution.
		
	}
	
	/**
	 * function tries to place maximum number of queens recursively for
	 * a given customized chess board and updates the solution matrix.
	 * 
	 * @param    vwall		vertical wall matrix  
	 * @param    hwall      horizontal wall matrix
	 * @param    i    	 	row
	 * @param    j    		column
	 */
	
	static void maxQueens(int[][] vwall,int[][] hwall,int i,int j){

		int m=findWall(vwall,i,j+1);
		int k;
		boolean queenPlaced = false;
		
		for(k=j;k<m;k++){
			if(isSafe(i,k,j,m,hwall,vwall)){
				soln[i][k]=1;
				queenPlaced = true;
				if(m!=board_size)
					maxQueens(vwall,hwall,i,m);
				else if(m==board_size && i<board_size-1)
					maxQueens(vwall,hwall,i+1,0);
			}
			
			if(!queenPlaced && k==m-1 && k!=board_size-1)
				maxQueens(vwall,hwall,i,m);
			
			if(!queenPlaced && k==board_size-1 &&  i<board_size-1)
				maxQueens(vwall,hwall,i+1,0);
			
			/* Back Tracking code starts from here; keeps track of
			   maximum queens that can placed on the chess board at any 
			   given point of time */
			
			if(soln[i][k]==1 && k!=m-1){
				int currentQueens = calculateQueens();
				if(currentQueens > maxQueens){
					maxQueens = currentQueens;
					
					for(int a=0;a<board_size;a++)
						for(int b=0;b<board_size;b++)
							finalSoln[a][b] = soln[a][b];
				}
				
				for(int x=k;x<board_size;x++)
					soln[i][x]=0;
				for(int x=i+1;x<board_size;x++)
					for(int y=0;y<board_size;y++){
						soln[x][y]=0;
				}
						
				if(isSafe(i,k+1,j,m,hwall,vwall)){
						soln[i][k+1]=1;
						if(m!=board_size)
							maxQueens(vwall,hwall,i,m);
						else if(i!=board_size-1)
							maxQueens(vwall,hwall,i+1,0);
				}
				else 
					soln[i][k]=1;
			}
		}
		
	}
	
	/**
	 * function to find the vertical wall in a given row
	 * after a particular position
	 * 
	 * @param    vwall   vertical wall matrix 
	 * @param    i    	 row
	 * @param    j       column
	 */
	
	static int findWall(int[][] vwall,int i,int j){
		for(int k=j;k<board_size;k++){
			if(vwall[i][k]==1)
				return k;
		}
		return board_size;	
	}
	
	/**
	 * function to check if given position is safe or not
	 * to place a queen.
	 * 
	 * @param    i        row
	 * @param    j        column
	 * @param    m    	  column where previous wall ended
	 * @param    n        column where next wall is located
	 * @param    hwall    horizontal wall matrix
	 * @param    vwall    vertical wall matrix
	 */
	
	static boolean isSafe(int i,int j,int m,int n,int[][] hwall,int[][] vwall){
		
		int k,l;
		int s = board_size-1;
		
		for (l=m;l<n;l++){
			if(soln[i][l]==1)
				return false;
		}

		for(k=i;k>=0;k--){
			if(hwall[k][j]==1){
				for(l=k;l<=i;l++)
					if(soln[l][j]==1)
						return false;
				break;
			}
		}
		
		if(k<0){
			for(l=0;l<=i;l++)
				if(soln[l][j]==1)
					return false;
		}
				
		for(k=i,l=j;k>0 && l>0;k--,l--){
			if(vwall[k][l]==1 || vwall[k-1][l]==1)
				break;
			else if(hwall[k][l]==1 || hwall[k][l-1]==1)
				break;
			else if(soln[k-1][l-1]==1)
				return false;
			else if(vwall[k-1][l-1]==1)
				break;
			else if(k-2>=0 && vwall[k-2][l-1]==1)
				break;
			else if(hwall[k-1][l-1]==1)
				break;
			else if(l-2>=0 && hwall[k-1][l-2]==1)
				break;
		}
		
		for(k=i,l=j;k>0 && l<s;k--,l++){
			if(vwall[k][l+1]==1 || vwall[k-1][l+1]==1)
				break;
			else if(hwall[k][l]==1 || hwall[k][l+1]==1)
				break;
			else if(soln[k-1][l+1]==1)
				return false;
			else if(l+2<=s && vwall[k-1][l+2]==1)
				break;
			else if(k-2>=0 && l+2<=s && vwall[k-2][l+2]==1)
				break;
			else if(hwall[k-1][l+1]==1)
				break;
			else if(l+2<=s && hwall[k-1][l+2]==1)
				break;
		}
		
		return true;
	} 
	
	/**
	 * function to print final solution matrix and maximum number 
	 * of queens that can be placed. 
	 *
	 */
	
	static void printSoln(){
		for(int i=0;i<board_size;i++){
			for(int j=0;j<board_size;j++){
				System.out.print(finalSoln[i][j]+" ");
			}
			System.out.println("");
		}
		
		System.out.println("Maximum queens that can be placed is: "+ maxQueens);
	}
	
	/**
	 * function to calculate number of queens that are currently placed
	 * in the given chess board.
	 *
	 */
	
	static int calculateQueens(){
		int count = 0;
		for(int i=0;i<board_size;i++){
			for(int j=0;j<board_size;j++){
				if(soln[i][j] == 1)
					count++;
			}
		}
		return count;
	}
	
}
