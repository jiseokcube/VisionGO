/*
 * File Name: InvalidSuperkoException
 * Project: VisionGO
 * Author: Eric Kim
 * Start Date: 12/24/2016
 * End Date:
 * Description: This class defines the error thrown when the move violates the superko rule.
 */

package model;

public class InvalidSuperkoException extends RuntimeException {
	public InvalidSuperkoException(String msg) {
		super(msg);
	}
}
