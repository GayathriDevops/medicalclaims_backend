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
 * @author Pradeepa AJ
 * Globly handling the exception using {@Controlleradvice and extending ResponseEntityExceptionHandler
 * to give all checked and unchecked exception in JSON response  }
 *
 */

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	/**
	 * 
	 * @param exception- handling checked and unchecked exception
	 * @param request- API request
	 * @return ResponseDto- message and status code
	 */
	
	@ExceptionHandler(Exception.class)

	public ResponseEntity<ResponseDto> globalExceptionHandler(Exception exception, WebRequest request) {
		

		return new ResponseEntity<>(ResponseDto.builder().message(exception.getMessage()).statusCode(HttpStatus.NOT_FOUND.value()).build(), HttpStatus.NOT_FOUND);

	}
	
	/**
	 * 
	 * @param InvalidCredentialsException- unchecked exception
	 * @param request- API request
	 * @return ResponseDto- message and status code
	 */
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ResponseDto> invalidCredentialsExceptionHandler(InvalidCredentialsException ex,
			WebRequest request) {
		ResponseDto responseDto = ResponseDto.builder().message(ex.getMessage()).statusCode(HttpStatus.UNAUTHORIZED.value())
				.build();
		return new ResponseEntity<>(responseDto, HttpStatus.UNAUTHORIZED);

	}
	
}