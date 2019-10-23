package com.hcl.helathcare.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.helathcare.dto.ClaimReqDto;
import com.hcl.helathcare.dto.ResponseDto;
import com.hcl.helathcare.exception.InvalidClaimAmountException;
import com.hcl.helathcare.exception.PolicyNotExistsException;
import com.hcl.helathcare.exception.UserNotExistsException;
import com.hcl.helathcare.service.ClaimService;

/**
 * 
 * Claim controller used to create new claim if the user and policy and claim
 * amount valid
 * 
 * @author Pradeepa AJ
 * @version 1.0
 * @since 2019-10-22
 *
 */
@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class ClaimController {
	private static final Logger logger = LoggerFactory.getLogger(ClaimController.class);

	@Autowired
	private ClaimService claimService;

	/**
	 * 
	 * @param ClaimReqDto
	 * @return ResponseDto http status code
	 * @throws UserNotExistsException
	 * @throws InvalidClaimAmountException
	 * @throws PolicyNotExistsException
	 */
	@PostMapping("/claims")
	public ResponseEntity<ResponseDto> createNewClaim(@RequestBody ClaimReqDto request)
			throws UserNotExistsException, InvalidClaimAmountException, PolicyNotExistsException {
		logger.info("::Enter into------------: createNewClaim()");
		return new ResponseEntity<>(claimService.createNewClaim(request), HttpStatus.CREATED);

	}

}
