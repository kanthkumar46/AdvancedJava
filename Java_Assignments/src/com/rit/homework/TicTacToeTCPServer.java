package com.rit.homework;

/* 
 * TicTacToeTCPServer.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
* This program creates a server socket which accepts any user
* trying to connect to it from other machine to play TicTacToe game.
*
* @author		Kanth
* @author 		Suman
*/

public class TicTacToeTCPServer {
	
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
		int row = Integer.parseInt(move[1]);
		int col = Integer.parseInt(move[2]);
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
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		
		try {
			serverSocket = new ServerSocket(8000); // server socket running on port 8000
			serverSocket.setSoTimeout(1000000);  // time out in ms
		} catch (IOException e) {
			System.out.println("Port 8000 is not available");
		}
		
		try {
			clientSocket = serverSocket.accept();  // accepts any client trying to connect on port 8000
		} catch (IOException e) {
			System.out.println("Not able to accept Client...!!!");
		}
		
		BufferedReader br = null;
		PrintStream ps = null;
		try {
			InputStream is =  clientSocket.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));  //reader to read from socket input stream
			ps = new PrintStream(clientSocket.getOutputStream()); //writer to write to socket output stream
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// initialize the board
		init();
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String serverInput; 
		String clientOutput;
		
		// execute until game is over 
		while((clientOutput = br.readLine())!=null){
			if(gameIsOn(clientOutput) && !boardFull){
				serverInput = scanner.nextLine();
				if(gameIsOn(serverInput) && !boardFull)
					ps.println(serverInput);
				else if(boardFull){
					System.out.println("Match Drawn !!");
					ps.println(serverInput);
					break;
				}
				else{
					System.out.println("you win..!!! hurray !! party :D :P");
					ps.println(serverInput);
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
		}

		br.close(); // close reader
		ps.close(); // close writer
		clientSocket.close(); // close client socket
		serverSocket.close(); // close server socket
	}
}
