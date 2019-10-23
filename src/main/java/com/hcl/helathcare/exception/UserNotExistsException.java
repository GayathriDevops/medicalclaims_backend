package com.hcl.helathcare.exception;

/**
 * UserNotExistsException if invalid user
 * 
 * @author Pradeepa AJ
 * @version 1.0
 * @since 2019-10-22
 *
 */
public class UserNotExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserNotExistsException(String message) {
		super(message);
	}
}
