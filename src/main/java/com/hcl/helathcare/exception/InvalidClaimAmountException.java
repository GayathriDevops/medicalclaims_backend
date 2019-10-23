package com.hcl.helathcare.exception;

/**
 * InvalidClaimAmountException if user enter invalid claim amount
 * 
 * @author Pradeepa AJ
 * @version 1.0
 * @since 2019-10-22
 *
 */
public class InvalidClaimAmountException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidClaimAmountException(String message) {
		super(message);
	}
}
