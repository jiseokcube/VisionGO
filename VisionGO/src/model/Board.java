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
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Note: 0 is empty, 1 (false) is black, 2 (true) is white

public class Board {
	private int[][] board;
	private int turn;
	private List<int[][]> history;
	
	// Default constructor
	// Creates an empty 19x19 board
	public Board() {
		board = new int[19][19];
		turn = 1;
		history = new ArrayList<int[][]>();
	}
	
	// Creates a 19x19 board from a given 19x19 array
	public Board(int[][] board, int turn) {
		this(board, turn, new ArrayList<int[][]>());
		addHistory(board);
	}
	
	// Creates a 19x19 board from a given 19x19 array and previous board states
		public Board(int[][] board, int turn, List<int[][]> history) {
			this.board = new int[19][19];
			this.history = new ArrayList<int[][]>();
			setBoard(board);
			setTurn(turn);
			setHistory(history);
		}
	
	// Gets the board
	public int[][] getBoard() {
		return board;
	}
	
	// Gets the turn
	public int getTurn() {
		return turn;
	}
	
	// Gets the move history
	public List<int[][]> getHistory() {
		return history;
	}
	
	// Sets the board to the given int array
	public void setBoard(int[][] board) {
		this.board = copyBoard(board);
	}
	
	// Sets the turn to the given player
	public void setTurn(int turn) {
		this.turn = turn;
	}
	
	// Sets the history to the given list of Board states
	public void setHistory(List<int[][]> history) {
		this.history.clear();
		for (int[][] board : history) {
			this.history.add(copyBoard(board));
		}
	}
	
	// Returns copy of a given int array
	public int[][] copyBoard(int[][] board) {
		int[][] newBoard = new int[19][19];
		
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				newBoard[i][j] = board[i][j];
			}
		}
		return newBoard;
	}
	
	// Adds board state to move history
	public void addHistory(int[][] board) {
		history.add(copyBoard(board));
	}
	
	// Returns a copy of the current Board object
	public Board copy() {
		return new Board(board, turn, history);
	}
	
	// Determines whether two Board objects are equal
	// Considered equal if board states are the same
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
	
	// Places a stone at the given coordinates disregarding all rules
	// Throws an error if intersection is occupied
	public void placeStone(int row, int col) {
		if (board[row][col] == 0) {
			board[row][col] = turn;
		}
		else {
			throw new InvalidMoveException("Intersection is already occupied.");
		}
	}
	
	// Removes the stone at the given coordinates
	public void removeStone(int row, int col) {
		board[row][col] = 0;
	}
	
	// Returns the value of the next player's turn given the current player's turn
	public int nextTurn() {
		return turn % 2 + 1;
	}
	
	// Checks if given list contains given array
	public boolean contains(List<int[]> list, int[] array) {
		for (int[] element : list) {
			if (Arrays.equals(element, array)) {
				return true;
			}
		}
		return false;
	}
	
	// Checks if given list contains given two-dimensional array
	public boolean contains(List<int[][]> list, int[][] array) {
		for (int[][] element : list) {
			if (Arrays.deepEquals(element, array)) {
				return true;
			}
		}
		return false;
	}
	
	// Makes a move at the given coordinates following all rules
	// Checks the superko rule
	// Throws the appropriate errors if move is invalid
	public void makeMove(int row, int col) {
		int[][] nextBoard = calcNextPos(row, col);
		
		if (!contains(history, nextBoard)) { // TODO: implement superko rule (add history of board states?)
			setBoard(nextBoard);
			setTurn(nextTurn());
			addHistory(nextBoard);
		}
		else {
			throw new InvalidMoveException("Violates superko rule: Cannot repeat a previous board position");
		}
	}
	
	// Returns a set of the coordinates of neighboring intersections
	public Set<int[]> getNeighbors(int row, int col) {
		Set<int[]> neighbors = new HashSet<int[]>();
		
		neighbors.add(new int[]{Math.max(0, row - 1), col});
		neighbors.add(new int[]{row, Math.max(0, col - 1)});
		neighbors.add(new int[]{row, Math.min(col + 1, 18)});
		neighbors.add(new int[]{Math.min(row + 1, 18), col});
		neighbors.remove(new int[]{row, col});
		return neighbors;
	}
	
	// Calculates the next position given a move
	// Checks the suicide rule
	// Returns an int array with the next state
	public int[][] calcNextPos(int row, int col) {
		Board nextBoard = this.copy();
		nextBoard.placeStone(row, col);
		
		List<int[]> allyCaptures = nextBoard.getCaptures(row, col);
		List<int[]> enemyCaptures = new ArrayList<int[]>();
		int[][] nextPos = nextBoard.getBoard();
		int nextTurn = nextBoard.nextTurn();
		
		for (int[] neighbor : nextBoard.getNeighbors(row, col)) {
			if (nextPos[neighbor[0]][neighbor[1]] == nextTurn && !contains(enemyCaptures, neighbor)) {
				enemyCaptures.addAll(nextBoard.getCaptures(neighbor[0], neighbor[1]));
			}
		}
		if (allyCaptures.size() == 0 && enemyCaptures.size() > 0) {
			throw new InvalidMoveException("Violates suicide rule: Cannot commit suicide");
		}
		
		for (int[] capture : enemyCaptures) {
			nextBoard.removeStone(capture[0], capture[1]);
		}
		return nextBoard.getBoard();
	}
	
	// Checks if the move is valid
	public boolean isValid(int row, int col) {
		return !contains(history, calcNextPos(row, col));
	}
	
	// Checks if the group connected to the given stone is captured
	// Uses a B.F. Sword (that's a lot of AD)
	// Returns a list with the coordinates of the stones that should be removed
	public List<int[]> getCaptures(int row, int col) {
		List<int[]> captures = new ArrayList<int[]>();
		
		if (board[row][col] != 0) {
			// TODO: implement BFS
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
