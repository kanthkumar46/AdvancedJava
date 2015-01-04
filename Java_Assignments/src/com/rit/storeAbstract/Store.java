package com.rit.storeAbstract;

import java.util.Scanner;

/* 
 * Store.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */

/**
 * This program stimulates the typical supermarket where customer 
 * can take the cart add items and bags to it; when the customer checkout 
 * cashier compute the total cost and generates the bill.
 * 
 *
 * @author      Kanth
 * @author      Suman
 */

public class Store{
	/**
	 * The main program.
	 *
	 * @param    args    command line arguments
	 */
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Customer customer = new Customer();
		Cart cart1 = null;
		Cart cart2 = null;
		
		// Prompt the items to buy until the customer checks out
		while(true){
			
			// options for customer to buy in super market
			System.out.println("1.Apple  2.Flour  3.Kiwi  4.Orange  5.Milk  6.Cart  7.Bag  8.Checkout");
			int option = in.nextInt();
		
			switch (option) {
			case 1:
				option = chooseCart(cart1, cart2, in);
				switch (option) {
				case 1:
					cart1.addItems("apple", 1);
					break;
				case 2:
					cart2.addItems("apple", 1);
					break;
				default:
					break;
				}
				break;
			case 2:
				option = chooseCart(cart1, cart2, in);
				switch (option) {
				case 1:
					cart1.addItems("flour", 1);
					break;
				case 2:
					cart2.addItems("flour", 1);
					break;
				default:
					break;
				}
				break;
			case 3:
				option = chooseCart(cart1, cart2, in);
				switch (option) {
				case 1:
					cart1.addItems("kiwi", 1);
					break;
				case 2:
					cart2.addItems("kiwi", 1);
					break;
				default:
					break;
				}
				break;
			case 4:
				option = chooseCart(cart1, cart2, in);
				switch (option) {
				case 1:
					cart1.addItems("orange", 1);
					break;
				case 2:
					cart2.addItems("orange", 1);
					break;
				default:
					break;
				}
				break;
			case 5:
				option = chooseCart(cart1, cart2, in);
				switch (option) {
				case 1:
					cart1.addItems("milk", 1);
					break;
				case 2:
					cart2.addItems("milk", 1);
					break;
				default:
					break;
				}
				break;
			case 6:
				if (cart1 == null)
					cart1 = customer.getCart();
				else if (cart2 == null)
					cart2 = customer.getCart();
				else
					System.out.println("Cannot have more than 2 Cart");
				break;
			case 7:
				option = chooseCart(cart1, cart2, in);
				if (option != 0) {
					Bag bag = customer.getBag();
					if (!addItemToBag(bag, in))
						option = 0;
					switch (option) {
					case 1:
						cart1.addItems(bag, 1);
						break;
					case 2:
						cart2.addItems(bag, 1);
						break;
					default:
						break;
					}
				}
				break;
			case 8:
				customer.checkout();
				System.exit(0);
				break;
			default:
				System.out.println("Select the valid option");
				break;
			}
		}
	}
	
	
	/**
	 * Method to add prompt the options to select the cart
	 * 
	 * @param    cart1   cart number 1
	 * @param    cart2   cart number 2
	 * @param	 in      standard input reader
	 */
	
	public static int chooseCart(Cart cart1,Cart cart2,Scanner in){
		if(cart1 != null && cart2 != null ){
			System.out.println("1.cart 1  2.cart 2");
			return in.nextInt();
		}
		else if(cart1 != null && cart2 == null){
			System.out.println("1.cart 1");
			return in.nextInt();
		}
		else {
			System.out.println("No Cart to add the item !! To get the cart press 6");
			return 0;
		}
	}
	
	
	/**
	 * Method to add selected items from standard input to the bag
	 * 
	 * @param    bag    selected bag
	 * @param    in     standard input reader
	 */
	
	public static boolean addItemToBag(Bag bag,Scanner in){
		System.out.println("Choose the item to add into bag");
		int i = in.nextInt();
		int count ;
		if(i == 1){
			System.out.println("Enter the number of Apples");
			count = in.nextInt();
			bag.addItems("apple", count);
		}
		else if(i == 2){
			System.out.println("Enter the number of Flour pieces");
			count = in.nextInt();
			bag.addItems("flour", count);
		}
		else if(i == 3){
			System.out.println("Enter the number of Kiwis");
			count = in.nextInt();
			bag.addItems("kiwi", count);
		}
		else if(i == 4){
			System.out.println("Enter the number of Oranges");
			count = in.nextInt();
			bag.addItems("orange", count);
		}
		else if(i == 5){
			System.out.println("Enter the number of Milk cartons");
			count = in.nextInt();
			bag.addItems("milk", count);
		}
		else{
			System.out.println("Cannot add selected item to bag");
			return false;
		}
		return true;
	}
	
}

/**
 * Class provides getter setter methods to set or return the
 * price of any items in the list. 
 * 
 * @author      Kanth
 * @author      Suman
 */

class PriceList{
	private static double applePrice = 50;
	private static double flourPrice = 70;
	private static double kiwiPrice = 70;
	private static double orangePrice = 70;
	private static double milkPrice = 33;
	
	/**
	 * Common getter function to return the price of any requested item.
	 * 
	 * @param    itemType    name of an item
	 */
	
	public static double getPrice(String itemType) {
		if(itemType.equals("apple"))
			return applePrice;
		else if(itemType.equals("flour"))
			return flourPrice;
		else if(itemType.equals("kiwi"))
			return kiwiPrice;
		else if(itemType.equals("orange"))
			return orangePrice;
		else
			return milkPrice;
	}

	/**
	 * setter functions to set the price of an individual item
	 * 
	 * @param    price    cost of an item
	 */
	
	public void setApplePrice(double price) {
		PriceList.applePrice = price;
	}

	public void setFlourPrice(double price) {
		PriceList.flourPrice = price;
	}

	public void setKiwiPrice(double price) {
		PriceList.kiwiPrice = price;
	}

	public void setOrangePrice(double price) {
		PriceList.orangePrice = price;
	}

	public void setMilkPrice(double price) {
		PriceList.milkPrice = price;
	}

}
