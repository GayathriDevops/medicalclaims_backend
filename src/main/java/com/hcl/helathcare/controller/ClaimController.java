package com.hcl.helathcare.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.helathcare.dto.ClaimResponse;
import com.hcl.helathcare.dto.PolicyResponse;
import com.hcl.helathcare.service.ClaimService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class ClaimController {
	
	private static final Logger logger = LoggerFactory.getLogger(ClaimController.class);
	@Autowired
	ClaimService claimService;
	
	/*
	 * @GetMapping("/members/{userId}/policies") public
	 * ResponseEntity<PolicyResponseDto> getPolicyByUserId(Long userId) {
	 * logger.info("Enter into Claim Controller::---------- getPolicyByUserId()");
	 * return new
	 * ResponseEntity<>(claimService.getPolicesByUserId(userId),HttpStatus.OK); }
	 */
	
	@GetMapping("/members/{userId}/claims")
    public ResponseEntity<ClaimResponse> getClaimsByUser(@PathVariable Long userId){
		logger.info("Enter into Claim Controller::---------- getClaimsByUser()");
           return new ResponseEntity<>(claimService.getClaimsByUser(userId),HttpStatus.OK);

    }

	@GetMapping("/members/{userId}/policy")
    public ResponseEntity<PolicyResponse> getPolicyByUser(@PathVariable Long userId){
		logger.info("Enter into Claim Controller::---------- getPolicyByUser()");
           return new ResponseEntity<>(claimService.getPolicesByUserId(userId),HttpStatus.OK);

    }


}
