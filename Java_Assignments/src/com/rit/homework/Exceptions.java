package com.rit.homework;
/* 
 * Exceptions.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This program produces all possible general exceptions. 
 *
 * @author      Kanth
 * @author      Suman
 */

public class Exceptions {
	
    /**
	 * The main program.
	 *
	 * @param    args    command line arguments
	 */

	public static void main(String[] args) {
	    int[] array = new int[5];
	    
	    // creates Array index out of bound exception
	    
	    try {
	    	for(int i=0;i<=5;i++)
	    		array[i]=i;
	    } catch(ArrayIndexOutOfBoundsException e){
	    	System.out.println("Array index out of bound exception "+e.getMessage());
	    }
	    
	    // creates arithmetic Exception
	    
	    try {
			int num = 3;
			num = num/0;
		} catch (ArithmeticException e) {
			System.out.println("Arithmetic Exception "+e.getMessage());
		}
	    
	    // creates Array Store Exception
	    
	    try {
			Object[] obj = new Integer[5];
			obj[0] = new String("lorem ipsum");
		} catch (ArrayStoreException e) {
			System.out.println("Array Store Exception "+e.getMessage());
		}
	    
	    // creates String index out of bound exception 
	    
	    try {
	    	String str= "lorem ipsum";
	    	char c = str.charAt(20);
			System.out.println(c);
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("String index out of bound exception "+e.getMessage());
		}
	    
	    // creates CLass Cast Exception
	    
	    try {
			Object str = new String("lorem ipsum");
			System.out.println((Integer) str);
		} catch (ClassCastException e) {
			System.out.println("CLass Cast Exception "+e.getMessage());
		}
	    
	    // creates Negative array size exception
	    
	    try {
			array = new int[-5];
		} catch (NegativeArraySizeException e) {
			System.out.println("Negative array size exception "+e.getMessage());
		}
	    
	    // creates Null Pointer Exception
	    try {
			String str = null;
			@SuppressWarnings("null")
			int length = str.length();
			System.out.println(length);
		} catch (NullPointerException e) {
			System.out.println("Null Pointer Exception "+e.getMessage());
		}
	    
	    // creates Number format Exception
	    
	    try{
	    	String str = "lorem ipsum";
	    	System.out.println(Integer.parseInt(str));
	    }catch(NumberFormatException e){
	    	System.out.println("Number format Exception "+e.getMessage());
	    }
	    
	    // creates File not found exception
	    
	    try {
	    	Scanner sc  = new Scanner( new File("src//lorem_ipsum.txt"));
			while ( sc.hasNext() )	{
				String line = sc.nextLine();
				System.out.println(line);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found exception "+e.getMessage());
		}
	    
	    // produces no such element exception in list
	    try{
	    	ArrayList<String> list = new ArrayList<String>();
	    	list.add("lorem ipsum");
	    	Iterator<String> itr = list.iterator();
	    	while(itr.hasNext()){
	    		itr.next();
	    	}
	    	itr.next();
	    }catch(NoSuchElementException e){
	    	System.out.println("No Such Element exception :"+e.getMessage());
	    }
	    
	    // creates EOF Exception
	    
	    try {
	    	File file = new File("src//palindrome_1.txt");
	    	@SuppressWarnings("resource")
			InputStream is = new FileInputStream(file);
	        while(true){
	        	if(is.read() == -1)
	        		throw new EOFException();
	        }
		} catch (EOFException e) {
			System.out.println("EOF Exception "+e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    // produces IO Exception
	    try {
	    	File file = new File("src//lorem ipsum.txt");
	    	@SuppressWarnings("resource")
			InputStream is = new FileInputStream(file);
	        while(is.read()!=-1){
	        	continue;
	        }
		} catch (IOException e) {
			System.out.println("IO Exception "+e.getMessage());
		}
	    
	}

}
