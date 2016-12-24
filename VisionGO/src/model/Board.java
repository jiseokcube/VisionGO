/*
 * File Name: Board.java
 * Project: VisionGO
 * Author: Eric Kim, Jiseok Choi, Chloe Choi
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
	public Board(int[][] board, int turn) {
		this.board = new int[19][19];
		setBoard(board);
		setTurn(turn);
	}
	/* Throw exception when invalid int? */
	
	// Returns a copy of the Board object
	public Board copy() {
		return new Board(board, turn);
	}
	
	// Gets the board
	public int[][] getBoard() {
		return board;
	}
	
	// Gets the turn
	public int getTurn() {
		return turn;
	}
	
	// Sets the board to the given int array
	public void setBoard(int[][] board) {
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				this.board[i][j] = board[i][j];
			}
		}
	}
	
	// Sets the turn to the given player
	public void setTurn(int turn) {
		this.turn = turn;
	}
	
	// Places a stone on the board given the coordinates
	// Returns true if successful, false if invalid
	public boolean placeStone(int row, int col) {
		board[row][col] = turn;
		turn = turn % 2 + 1;
		msg = checkValid(color, row, col);
		if (msg.equals("")) {
			board[row][col] = color;
		}
		return msg;
	}
	
	// Calculates next position given a move
	// Returns next position but does not update the board
	public int[][] calcNextPos(int row, int col) {
		// Check if empty
		// Check for suicide
		// Use getCaptures
	}
	
	// Checks if the move is valid
	// Returns true if a valid move, false if invalid
	public boolean isValid(int row, int col) {
		Board newBoard = this.copy();
		int[][] newPos = newBoard.calcNextPos(row, col);
		newBoard.setBoard(newPos);
		return !equals(newBoard);
	}
	
	// Checks if any stones are captured
	// Returns a list with the coordinates of the stones that should be removed
	// Uses the last move to efficiently calculate
	public int[][] getCaptures(int row, int col) {
		// graph search (bfs)
	}
	
	public int calculateScore() {
		
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
