package com.hcl.helathcare.exception;

/**
 * InvalidClaimAmountException if invalid policy
 * 
 * @author Pradeepa AJ
 * @version 1.0
 * @since 2019-10-22
 *
 */
public class PolicyNotExistsException extends Exception {
	private static final long serialVersionUID = 1L;

	public PolicyNotExistsException(String message) {
		super(message);
	}
}
