package com.hcl.helathcare.service;

import com.hcl.helathcare.dto.ClaimReqDto;
import com.hcl.helathcare.dto.ResponseDto;
import com.hcl.helathcare.exception.InvalidClaimAmountException;
import com.hcl.helathcare.exception.PolicyNotExistsException;
import com.hcl.helathcare.exception.UserNotExistsException;

public interface ClaimService {

	ResponseDto createNewClaim(ClaimReqDto request)  throws UserNotExistsException ,
	InvalidClaimAmountException, PolicyNotExistsException;

}
