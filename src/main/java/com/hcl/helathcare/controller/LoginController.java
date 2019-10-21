package com.hcl.helathcare.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.helathcare.dto.LoginReqDto;
import com.hcl.helathcare.dto.LoginResDto;
import com.hcl.helathcare.service.LoginService;

/**
 * 
 *
 *
 *login()-check user exits and validate with data is true return userId
 * @author Pradeep AJ
 *
 */
@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private LoginService loginService;
	

	/**
	 * 
	 * @param loginReqDto
	 * @return LoginResDto
	 */
	
	@PostMapping("/users/login")
	public ResponseEntity<LoginResDto> login(@Valid @RequestBody LoginReqDto loginReqDto){
		logger.info("Enter into UserController::---------- login()");
		return new ResponseEntity<>(loginService.login(loginReqDto),HttpStatus.OK);
	}
}
