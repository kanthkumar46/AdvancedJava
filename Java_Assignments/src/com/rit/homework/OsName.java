package com.rit.homework;
/* 
 * OsName.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */

/**
 * This program prints the same of operating system
 * the user is currently working on.
 *
 * @author      Kanth
 */

class OsName {
	
	/**
	 * The main program.
	 *
	 * @param    args    command line arguments
	 */
	
 	public static void main (String args []) { 
 		// get the name of Operating System from System Properties
 		
 		String osName = System.getProperty("os.name"); 
 		
 		//print out the name of Operating System. 
 		
 		System.out.println("OS:"+" "+osName);
 	}
 	
 }
