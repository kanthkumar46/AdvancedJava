package com.rit.homework;

/* 
 * TicTacToeUDPSever.java 
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
import java.util.Scanner;

/**
* This program creates Datagram socket and keeps waiting 
* for another user to get connected to play TicTacToe game
* 
* @author		Kanth
* @author 		Suman
*/

public class TicTacToeUDPSever {
	
	static String[][] ticTacToe = new String[3][3]; // TicTacToe game board
	static boolean boardFull = false;  // flag to check if board is filled
	
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
		ticTacToe[row][col] = move[0];
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
		for (int i = 0; i < 3; i++) {
			if (ticTacToe[0][0].equals(ticTacToe[1][1])
					&& ticTacToe[1][1].equals(ticTacToe[2][2]))
				return false;
			else if (ticTacToe[0][2].equals(ticTacToe[1][1])
					&& ticTacToe[1][1].equals(ticTacToe[2][0]))
				return false;
		}

		// check rows
		for (int i = 0; i < 3; i++) {
			if (ticTacToe[i][0].equals(ticTacToe[i][1])
					&& ticTacToe[i][1].equals(ticTacToe[i][2]))
				return false;
		}

		// check columns
		for (int i = 0; i < 3; i++) {
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
		DatagramSocket serverSocket = null;
		
		try {
			serverSocket = new DatagramSocket(8000);  // socket that waits on port 8000
		} catch (IOException e) {
			System.out.println("Port 8000 is not available");
		}
		
		byte[] clientData = new byte[1024];
		byte[] severData = new byte[1024];
		
		init();
		
		DatagramPacket clinetPacket; // packet to send 
		DatagramPacket severPacket; // packet to recive
		
		clinetPacket = new DatagramPacket(clientData, clientData.length);
		serverSocket.receive(clinetPacket); // receive packet from client machine
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String serverInput; 
		String clientOutput = new String(clinetPacket.getData());
		
		// execute until game is over 
		while(clientOutput !=null){
			if(gameIsOn(clientOutput) && !boardFull){
				serverInput = scanner.nextLine();
				if(gameIsOn(serverInput) && !boardFull){
					severData = serverInput.getBytes();
					severPacket = new DatagramPacket(severData, severData.length, 
							clinetPacket.getAddress(), clinetPacket.getPort());
					serverSocket.send(severPacket);  // send packet to client machine
				}
				else if(boardFull){
					System.out.println("Match Drawn !!");
					severData = serverInput.getBytes();
					severPacket = new DatagramPacket(severData, severData.length, 
							clinetPacket.getAddress(), clinetPacket.getPort());
					serverSocket.send(severPacket);  // send packet to client machine
					break;
				}
				else{
					System.out.println("you win..!!! hurray !! party :D :P");
					severData = serverInput.getBytes();
					severPacket = new DatagramPacket(severData, severData.length, 
							clinetPacket.getAddress(), clinetPacket.getPort());
					serverSocket.send(severPacket); // send packet to client machine
					break;
				}
			}
			else if(boardFull){
				System.out.println("Match Drawn !!");
				break;
			}
			else{
				System.out.println("you lose !! :( :'( ");
				break;
			}
			
			clinetPacket = new DatagramPacket(clientData, clientData.length);
			serverSocket.receive(clinetPacket); // receive packet from client machine 
			clientOutput = new String(clinetPacket.getData());
		}
		
		serverSocket.close();  // close socket
	}
}
