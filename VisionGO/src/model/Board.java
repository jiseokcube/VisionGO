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
	
	// Returns a copy of the Board object
	public Board clone() {
		return new Board(board, turn);
	}
	
	// Copies fields from another Board object
	public void copy(Board board) {
		setBoard(board.getBoard());
		setTurn(board.getTurn());
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
	
	// Places a stone at the given coordinates disregarding rules
	// Returns true if successful, false if the intersection is occupied
	public boolean placeStone(int row, int col) {
		if (board[row][col] == 0) {
			board[row][col] = turn;
			return true;
		}
		return false;
	}
	
	// Removes the stone at the given coordinates
	// Returns the color of the removed stone (0 if empty)
	public int removeStone(int row, int col) {
		int color = board[row][col];
		board[row][col] = 0;
		return color;
	}
	
	// Makes a move at the given coordinates following rules
	// Throws appropriate errors if move is invalid
	public void makeMove(int row, int col) {
		Board nextBoard = calcNextPos(row, col);
		if (!equals(nextBoard)) { // need to implement superko rule (add history of board states?)
			copy(nextBoard);
		}
	}
	
	// Calculates next position given a move
	// Checks if the move is valid, if not throws appropriate errors
	// Returns a new Board with the next state
	public Board calcNextPos(int row, int col) {
		Board nextBoard = this.clone();
		if (placeStone(row, col)) {
			
		}
		return nextBoard;
	}
	
	// Checks if the move is valid
	// Returns true if a valid move, false if invalid
	public boolean isValid(int row, int col) {
		Board nextBoard = calcNextPos(row, col);
		return !equals(nextBoard);
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
}
