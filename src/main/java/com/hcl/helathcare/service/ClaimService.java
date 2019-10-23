package com.hcl.helathcare.service;

import com.hcl.helathcare.dto.ClaimReqDto;
import com.hcl.helathcare.dto.ResponseDto;
import com.hcl.helathcare.exception.InvalidClaimAmountException;
import com.hcl.helathcare.exception.PolicyNotExistsException;
import com.hcl.helathcare.exception.UserNotExistsException;

/**
 * ClaimService have one abstract methods
 * 
 * @author Pradeepa AJ
 * @version 1.0
 * @since 2019-10-22
 *
 */
public interface ClaimService {
	/**
	 * 
	 * @param request NotNull 
	 * @return ResponseDto
	 * @throws UserNotExistsException
	 * @throws InvalidClaimAmountException
	 * @throws PolicyNotExistsException
	 */
	ResponseDto createNewClaim(ClaimReqDto request)
			throws UserNotExistsException, InvalidClaimAmountException, PolicyNotExistsException;

}
