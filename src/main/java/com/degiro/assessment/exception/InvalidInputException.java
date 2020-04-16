package com.degiro.assessment.exception;

/**
 * @author Sudhakaran
 * 
 * Generic custom exception to handle all Data/format error in input
 *
 */
public class InvalidInputException extends Exception {

	private static final long serialVersionUID = -2977724270668772732L;

	public InvalidInputException(String message) {
		super(message);
	}

}
