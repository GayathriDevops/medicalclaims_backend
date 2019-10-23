package com.hcl.helathcare.service;

import javax.validation.Valid;

import com.hcl.helathcare.dto.LoginReqDto;
import com.hcl.helathcare.dto.LoginResDto;
import com.hcl.helathcare.exception.InvalidCredentialsException;
/**
 * LoginService have one abstract methods
 * 
 * @author Pradeepa AJ
 * @version 1.0
 * @since 2019-10-22
 *
 */
public interface LoginService {
	
	/**
	 * 
	 * @param loginReqDto NotNull
	 * @return LoginReqDto 
	 * @throws InvalidCredentialsException
	 */

	LoginResDto login(@Valid LoginReqDto loginReqDto)throws InvalidCredentialsException;

}
