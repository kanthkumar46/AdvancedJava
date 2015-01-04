package com.rit.homework;

/* 
 * TicTacToeUDPClient.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
* This program creates Datagram socket and allows user
* to connect another known machine to play TiTacToe Game.
* 
* @author		Kanth
* @author 		Suman
*/

public class TicTacToeUDPClient {
	static String[][] ticTacToe = new String[3][3]; // TicTacToe game board
	static boolean boardFull = true; // flag to check if board is filled
	
	/**
	 * function to initialize the game board
	 *
	 */
	static void init(){
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				ticTacToe[i][j] = "("+i+","+j+")";
		printBoard();
	}
	
	/**
	 * function to check if game is over or still on
	 * 
	 * @param	nextMove	string representing position and value placed on board 
	 */
	static boolean gameIsOn(String nextMove){
		String[] move = nextMove.split(" ");
		int row = Integer.parseInt(move[1].trim());
		int col = Integer.parseInt(move[2].trim());
		ticTacToe[row][col] = move[0].trim();
		printBoard();
		
		// Check if board is completely filled
		boardFull = true;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(!ticTacToe[i][j].equals("x") && !ticTacToe[i][j].equals("o"))
					boardFull = false;
			}
		}
	
		// check diagonals
		for(int i=0;i<3;i++){
			if(ticTacToe[0][0].equals(ticTacToe[1][1])
					&& ticTacToe[1][1].equals(ticTacToe[2][2]))
				return false;
			else if(ticTacToe[0][2].equals(ticTacToe[1][1]) 
					&& ticTacToe[1][1].equals(ticTacToe[2][0]))
				return false;
		}
		
		// check rows
		for(int i=0;i<3;i++){
			if (ticTacToe[i][0].equals(ticTacToe[i][1]) 
					&& ticTacToe[i][1].equals(ticTacToe[i][2]))
				return false;
		}
		
		// check columns
		for(int i=0;i<3;i++){
			if (ticTacToe[0][i].equals(ticTacToe[1][i]) 
					&& ticTacToe[1][i].equals(ticTacToe[2][i]))
				return false;
		}
		
		return true;	
	}
	
	/**
	 * function to print the game board
	 *
	 */
	static void printBoard(){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print(ticTacToe[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * The main program.
	 *
	 * @param    args    command line arguments
	 */
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket();  // socket to send and receive packets to server
		InetAddress inetAddress = InetAddress.getByName("127.0.0.1"); // ip address of machine to connect
		
		byte[] clientData = new byte[1024];
		byte[] severData = new byte[1024];
		

		// initialize the board
		init();
		
		DatagramPacket clinetPacket; // packet to send 
		DatagramPacket severPacket; // packet to recive
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String clientInput;
		String serverOutput;
		
		// execute until game is over 
		while((clientInput = scanner.nextLine()) != null){
			if(gameIsOn(clientInput) && !boardFull){
				clientData = clientInput.getBytes();
				clinetPacket = new DatagramPacket(clientData, clientData.length,
						inetAddress, 8000);
				socket.send(clinetPacket); // send packet to machine on port 8000
			}
			else if(boardFull){
				System.out.println("Match Drawn !!");
				clientData = clientInput.getBytes();
				clinetPacket = new DatagramPacket(clientData, clientData.length,
						inetAddress, 8000);
				socket.send(clinetPacket);  // send packet to machine on port 8000
				break;
			}
			else{
				System.out.println("you win..!!! hurray !! party :D :P");
				clientData = clientInput.getBytes();
				clinetPacket = new DatagramPacket(clientData, clientData.length,
						inetAddress, 8000);
				socket.send(clinetPacket); // send packet to machine on port 8000
				break;
			}
			
			severPacket = new DatagramPacket(severData, severData.length);
			socket.receive(severPacket); // receive packet for the machine to which user is connect to
			serverOutput = new String(severPacket.getData());
			if(gameIsOn(serverOutput) && !boardFull)
				continue;
			else if(boardFull){
				System.out.println("Match Drawn !!");
				break;
			}
			else{
				System.out.println("you lose !! :( :'( ");
				break;
			}	
		}
		
		socket.close();  // close socket
	}
}
