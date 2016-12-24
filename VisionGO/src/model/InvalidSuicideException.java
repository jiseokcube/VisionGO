/*
 * File Name: InvalidSuicideException
 * Project: VisionGO
 * Author: Eric Kim
 * Start Date: 12/24/2016
 * End Date:
 * Description: This class defines the error thrown when the move is suicidal.
 */

package model;

public class InvalidSuicideException extends RuntimeException {
	public InvalidSuicideException(String msg) {
		super(msg);
	}
}
