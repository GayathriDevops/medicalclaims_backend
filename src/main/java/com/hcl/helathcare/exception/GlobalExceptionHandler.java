package com.hcl.helathcare.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hcl.helathcare.dto.ResponseDto;

/**
 * 
 * Globaly handling the exception using Controlleradvice and extending
 * ResponseEntityExceptionHandler to give all checked and unchecked exception in
 * JSON response
 * 
 * @author Pradeepa AJ
 * @version 1.0
 * @since 2019-10-22
 *
 */

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * 
	 * @param exception handling checked and unchecked exception
	 * @param request   API request
	 * @return ResponseDto message and status code
	 */

	@ExceptionHandler(Exception.class)

	public ResponseEntity<ResponseDto> globalExceptionHandler(Exception exception, WebRequest request) {

		return new ResponseEntity<>(
				ResponseDto.builder().message(exception.getMessage()).statusCode(HttpStatus.NOT_FOUND.value()).build(),
				HttpStatus.NOT_FOUND);

	}

	/**
	 * 
	 * @param InvalidCredentialsException checked and unchecked exception
	 * @param request                     API request
	 * @return ResponseDto- message and status code
	 */
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ResponseDto> invalidCredentialsExceptionHandler(InvalidCredentialsException ex,
			WebRequest request) {
		ResponseDto responseDto = ResponseDto.builder().message(ex.getMessage())
				.statusCode(HttpStatus.UNAUTHORIZED.value()).build();
		return new ResponseEntity<>(responseDto, HttpStatus.UNAUTHORIZED);

	}

	/**
	 * 
	 * @param UserNotExistsException checked and unchecked exception
	 * @param request                API request
	 * @return ResponseDto- message and status code
	 */

	@ExceptionHandler(UserNotExistsException.class)
	public ResponseEntity<ResponseDto> userNotExistsExceptionHandler(UserNotExistsException ex, WebRequest request) {
		ResponseDto responseDto = ResponseDto.builder().message(ex.getMessage())
				.statusCode(HttpStatus.UNAUTHORIZED.value()).build();
		return new ResponseEntity<>(responseDto, HttpStatus.UNAUTHORIZED);

	}

	/**
	 * 
	 * @param PolicyNotExistsException checked and unchecked exception
	 * @param request                  API request
	 * @return ResponseDto- message and status code
	 */

	@ExceptionHandler(PolicyNotExistsException.class)
	public ResponseEntity<ResponseDto> policyNotExistsException(PolicyNotExistsException ex, WebRequest request) {
		ResponseDto responseDto = ResponseDto.builder().message(ex.getMessage())
				.statusCode(HttpStatus.UNAUTHORIZED.value()).build();
		return new ResponseEntity<>(responseDto, HttpStatus.UNAUTHORIZED);

	}

	/**
	 * 
	 * @param InvalidClaimAmountException checked and unchecked exception
	 * @param request                     API request
	 * @return ResponseDto- message and status code
	 */
	@ExceptionHandler(InvalidClaimAmountException.class)
	public ResponseEntity<ResponseDto> fileStorageExceptionHandler(InvalidClaimAmountException ex, WebRequest request) {
		ResponseDto responseDto = ResponseDto.builder().message(ex.getMessage())
				.statusCode(HttpStatus.BAD_REQUEST.value()).build();
		return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);

	}

}