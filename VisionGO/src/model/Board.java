/*
 * File Name: Board.java
 * Project: VisionGO
 * Author: Eric Kim, Jiseok Choi
 * Start Date: 12/23/2016
 * End Date:
 * Description: This is the class file for the board object.
 */

package model;

// Note: 0 is empty, 1 is black, 2 is white

public class Board {
	private int[][] board;

	// Default constructor
	// Creates a 19x19 board and sets each values equal to null
	public Board() {
		board = new int[19][19];
	}

	// Creates a 19x19 board and copies over the the input board
	public Board(Board board1) {
		board = new int[19][19];

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				board[i][j] = board1.getBoard()[i][j];
			}
		}
	}

	// Gets the board
	public int[][] getBoard() {
		return board;
	}

	// Places a stone on the board given the stone color and coordinates
	public String placeStone(int color, int row, int col) {
		msg = checkValid(color, row, col);
		if (msg.equals("")) {
			board[row][col] = color;
		}
		return msg;
	}

	// Checks if the placement is valid
	// Returns an empty string if it is valid
	// Returns the error message if invalid
	public String checkValid(int color, int row, int col) {

	}

	// Checks if any stones are captured
	// Returns an 2d int array with the stone indexes of the stones should be
	// removed
	// The first row represents the row index of the stones
	// The second row represents the column index of the stones
	public int[][] checkCapture() {

	}

	// Removes a stone from the board given the coordinates
	// Sets the given index to 0
	public void removeStone(int row, int col) {
		board[row][col] = 0;
	}

	// Determines the winner
	// Returns the player as an int
	// 1 is black, 0 is white
	public int determineWinner() {

	}

	// Determines whether two board objects are equal
	public boolean equals(Board board1) {
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (board[i][j] != board1.getBoard()[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
