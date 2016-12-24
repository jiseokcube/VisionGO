// DEPRECATED

/*
 * File Name: Stone.java
 * Project: VisionGO
 * Author: Eric Kim, Jiseok Choi
 * Start Date: 12/23/2016
 * End Date: 12/23/2016
 * Description: This is the class file for the stone object.
 */

package model;

public class Stone {
	// Color: 1 is black, 0 is white
	private int color;
	private int row;
	private int col;

	public Stone(int color1, int row1, int col1) {
		color = color1;
		row = row1;
		col = col1;
	}

	public int getColor() {
		return color;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public boolean equals(Stone stone1) {
		return color == stone1.getColor() && row == stone1.getRow() && col == stone1.getCol();
	}
}
