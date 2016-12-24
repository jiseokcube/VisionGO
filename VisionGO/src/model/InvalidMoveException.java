/*
 * File Name: InvalidMoveException
 * Project: VisionGO
 * Author: Eric Kim, Jiseok Choi
 * Start Date: 12/24/2016
 * End Date: 12/24/2016
 * Description: This class defines the error thrown when the move is invalid.
 */

package model;

public class InvalidMoveException extends RuntimeException {
	public InvalidMoveException(String message) {
		super(message);
	}
}
