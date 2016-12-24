/*
 * File Name: CannotCommitSuicideException
 * Project: VisionGO
 * Author: Eric Kim
 * Start Date: 12/24/2016
 * End Date:
 * Description: This class defines the error thrown when the move is suicidal
 */

package model;

public class InvalidSuicidalException extends RuntimeException {

	public InvalidSuicidalException(String msg) {
		super(msg);
	}

}
