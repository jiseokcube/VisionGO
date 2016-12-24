/*
 * File Name: Board.java
 * Project: VisionGO
 * Author: Eric Kim
 * Start Date: 12/23/2016
 * End Date:
 * Description: This is the class file for the board object
 */

package model;

import java.util.ArrayList;

public class Board {
	private ArrayList<ArrayList<Stone>> board;

	// Default constructor
	// Creates a 19x19 board and sets each values equal to null
	public Board() {
		board = new ArrayList<ArrayList<Stone>>();

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				board.get(i).set(j, null);
			}
		}
	}

	// Creates a 19x19 board and copies over the the input board
	public Board(Board board1) {
		board = new ArrayList<ArrayList<Stone>>();

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				board.get(i).set(j, board1.getBoard().get(i).get(j));
			}
		}
	}

	// Gets the board
	public ArrayList<ArrayList<Stone>> getBoard() {
		return board;
	}

	// Places a stone on the board given the stone color and coordinates
	public String placeStone(int color, int row, int col) {
		msg = checkValid(color, row, col);
		if (msg == "") {
			board.get(row).set(col, new Stone(color, row, col));
		}
		return msg;
	}

	// Checks if the placement is valid
	// Returns an empty string if it is valid
	// Returns the error message if invalid
	public String checkValid(int color, int row, int col) {

	}

	// Checks if any stones are captured
	// Returns an arraylist of the stones that are captured
	// The arraylist is empty if no stones are captured
	public ArrayList<Stone> checkCapture() {

	}

	// Removes a stone from the board given the coordinates
	public void removeStone(int row, int col) {
		board.get(row).set(col, null);
	}

	// Determines the winner
	// Returns the player as an int
	public int determineWinner() {

	}

	// Determines whether two board objects are equal
	public boolean equals(Board board1) {
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (board.get(i).get(j) == null && board1.getBoard().get(i).get(j) == null) {
				} else if (board.get(i).get(j) == null || board1.getBoard().get(i).get(j) == null) {
					return false;
				} else if (!(board.get(i).get(j).equals(board1.getBoard().get(i).get(j)))) {
					return false;
				}
			}
		}
		return true;
	}

}
