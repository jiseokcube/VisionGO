/*
 * File Name: Board.java
 * Project: VisionGO
 * Author: Eric Kim, Jiseok Choi
 * Start Date: 12/23/2016
 * End Date:
 * Description: This is the class file for the board object
 */

package model;

//Note: 0 is empty, 1 (false) is black, 2 (true) is white

public class Board {
	private int[][] board;
	private int turn;
	
	// Default constructor
	// Creates a 19x19 board and sets each values equal to null
	public Board() {
		board = new int[19][19];
		turn = 1;
	}
	
	// Creates a 19x19 board from a input 19x19 array
	public Board(int[][] board) {
		this.board = new int[19][19];
		turn = 1;
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				this.board[i][j] = board[i][j];
			}
		}
	}
	
	// Creates a board from a input Board object
	public Board(Board board) {
		this(board.getBoard());
	}
	
	// Gets the board
	public int[][] getBoard() {
		return board;
	}
	
	// Gets the turn
	public int getTurn() {
		return turn;
	}
	
	// Places a stone on the board given the coordinates
	// Returns true if successful, false if invalid
	public String placeStone(int row, int col) {
		board[row][col] = turn;
		turn = turn % 2 + 1;
		msg = checkValid(color, row, col);
		if (msg.equals("")) {
			board[row][col] = color;
		}
		return msg;
	}
	
	// Removes a stone from the board given the coordinates
	private void removeStone(int row, int col) {
		board[row][col] = null;
	}

	// Checks if the placement is valid
	// Returns an empty string if it is valid
	// Returns the error message if invalid
	public boolean checkValid(int row, int col) {
		
	}

	// Checks if any stones are captured
	// Returns an 2d int array with the stone indexes of the stones should be
	// removed
	// The first row represents the row index of the stones
	// The second row represents the column index of the stones
	public int[][] checkCapture() {

	}

	// Determines the winner
	// Returns the player as an int
	public int determineWinner() {

	}

	// Determines whether two board objects are equal
	public boolean equals(Board board) {
		int[][] otherBoard = board.getBoard();
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (this.board[i][j] != otherBoard[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
