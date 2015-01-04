package com.rit.homework;

class MaxKings{

	static int[][] soln = new int[][]{
/*			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 2, 0, 0, 2, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 2, 0, 0, 2, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },*/
			
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
	};
	
	static int board_size =4;
	
	static boolean isSafe(int[][] m,int i,int j){
		
		int n = board_size;
		
		if((j-1>=0 && (m[i][j-1]==2 || m[i][j-1]==3)) 
				|| (j+1<n && (m[i][j+1]==2 || m[i][j+1]==3)))
			return false;
		else if((i-1>=0 && (m[i-1][j]==2 || m[i-1][j]==3)) 
				|| (i+1<n && (m[i+1][j]==2 || m[i+1][j]==3)))
			return false;
		else if(((j-1>=0 && i-1>=0) && (m[i-1][j-1]==2 || m[i-1][j-1]==3)) 
				|| ((j+1<n && i+1<n) && (m[i+1][j+1]==2 || m[i+1][j+1]==3)))
			return false;
		else if(((j-1>=0 && i+1<n) && (m[i+1][j-1]==2 || m[i+1][j-1]==3)) 
				|| ((i-1>=0 && j+1<n) && (m[i-1][j+1]==2 || m[i-1][j+1]==3)))
			return false;
		else if(m[i][j]==2 || m[i][j]==3)
			return false;
		else 
			return true;
	
	} 
	
	static void maxKings(int[][] m,int i,int k){
		for(int j=k;j<board_size;j++){
			if(m[i][j]!=0 && isSafe(m,i,j)){
				m[i][j]=3;
				soln[i][j]=1;
				if(j<board_size-1) 
					maxKings(m,i,j+1);
			}
			
			if(i<board_size-1 && j==board_size-1)
				maxKings(m,i+1,0);
		}
	}
	
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
	
	public static void main (String[] args){
		int[][] m = new int[][]{
/*			{1, 1, 1, 1, 0, 0, 1, 1, 1, 1 },
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{1, 1, 1, 2, 1, 1, 2, 1, 1, 1 },
			{0, 1, 1, 1, 0, 0, 1, 1, 1, 0 },
			{0, 1, 1, 1, 0, 0, 1, 1, 1, 0 },
			{1, 1, 1, 2, 1, 1, 2, 1, 1, 1 },
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{1, 1, 1, 1, 0, 0, 1, 1, 1, 1 },*/
			
				{1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1},
		};
		
		maxKings(m,0,0);
		
		printSoln();
		/*if(isSafe(m,8,6)){
			System.out.println("hello");
		}*/
		
	}
}
