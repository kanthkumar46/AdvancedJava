package com.rit.homework;

import java.io.File;
import java.util.Scanner;

public class Palindrome {
	public static void main( String[] args ) {
		try {
			Scanner sc  = new Scanner( new File("src//palindrome_1.txt"));
			int count=0;
			while ( sc.hasNext() )	{
				String line = sc.nextLine();
				for(int i=0;i<line.length();i++)
					for(int j=i+2;j<line.length();j++){
					if(isPalindrome(line.toLowerCase(), i, j)){
						count++;
						System.out.println(line.substring(i, j+1));
					}
				}
			}
			System.out.println("Total Palindromes in a given text file :"+count);
			sc.close();
		} catch ( Exception e )	{
			System.err.println("Something went wrong!"+e);
		}
	}
	
	static boolean isPalindrome(String str,int m,int n){
		for (int i=m;i<=(m+n)/2;i++){
			if(str.charAt(i)==str.charAt(m+n-i))
				continue;
			else 
				return false;
		}
		return true;	
	}
	
}
