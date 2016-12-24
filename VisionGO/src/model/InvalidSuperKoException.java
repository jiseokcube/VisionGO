/*
 * File Name: ViolatesSuperKoRulesException
 * Project: VisionGO
 * Author: Eric Kim
 * Start Date: 12/24/2016
 * End Date:
 * Description: This class defines the error thrown when the move is invalid
 */

package model;

public class InvalidSuperKoException extends RuntimeException {

	public InvalidSuperKoException(String msg) {
		super(msg);
	}
}
