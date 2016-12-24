/*
 * File Name: Board.java
 * Project: VisionGO
 * Author: Eric Kim, Jiseok Choi, Chloe Choi
 * Start Date: 12/23/2016
 * End Date: 
 * Description: This is the class file for the Board object.
 */

package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	// Throws error if intersection is occupied
	public void placeStone(int row, int col) {
		if (board[row][col] == 0) {
			board[row][col] = turn;
		}
		else {
			throw new InvalidMoveException("Intersection is already occupied.");
		}
	}
	
	// Removes the stone at the given coordinates
	// Returns the color of the removed stone (0 if empty)
	public void removeStone(int row, int col) {
		board[row][col] = 0;
	}
	
	// Makes a move at the given coordinates following rules
	// Checks superko rule
	// Throws appropriate errors if move is invalid
	public void makeMove(int row, int col) {
		Board nextBoard = calcNextPos(row, col);
		if (!equals(nextBoard)) { // need to implement superko rule (add history of board states?)
			copy(nextBoard);
		}
		else {
			throw new InvalidMoveException("Violates superko rule: Cannot repeat a previous board position");
		}
	}
	
	// Gets the coordinates of neighboring intersections
	public Set<int[]> getNeighbors(int row, int col) {
		Set<int[]> neighbors = new HashSet<int[]>();
		neighbors.add(new int[]{Math.max(0, row - 1), col});
		neighbors.add(new int[]{row, Math.max(0, col - 1)});
		neighbors.add(new int[]{row, Math.min(col + 1, 18)});
		neighbors.add(new int[]{Math.min(row + 1, 18), col});
		neighbors.remove(new int[]{row, col});
		return neighbors;
	}
	
	// Calculates next position given a move
	// Checks suicide rule
	// Returns a new Board with the next state
	public Board calcNextPos(int row, int col) {
		Board nextBoard = this.clone();
		placeStone(row, col);
		List<int[]> allyCaptures = getCaptures(row, col);
		List<int[]> enemyCaptures = new ArrayList<int[]>();
		for (int[] neighbor : getNeighbors(row, col)) {
			
		}
		return nextBoard;
	}
	
	// Checks if the move is valid
	// Returns true if a valid move, false if invalid
	public boolean isValid(int row, int col) {
		Board nextBoard = calcNextPos(row, col);
		return !equals(nextBoard);
	}
	
	// Checks if the group connected to the given stone is captured
	// Returns a list with the coordinates of the stones that should be removed
	public List<int[]> getCaptures(int row, int col) {
		List<int[]> captures = new ArrayList<int[]>();
		if (board[row][col] != 0) {
			
		}
		return captures;
	}
	
	public int calculateScore() {
		
	}
	
	// Determines the winner
	// Returns the player as an int
	public int determineWinner() {
		
	}
}
