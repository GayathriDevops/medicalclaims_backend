package com.hcl.helathcare.service;


import com.hcl.helathcare.dto.ClaimResponse;
import com.hcl.helathcare.dto.PolicyResponse;


public interface ClaimService {
	/* public PolicyResponseDto getPolicesByUserId(Long userId); */
	public ClaimResponse getClaimsByUser(Long userId);
	
	public PolicyResponse getPolicesByUserId(Long userId);
}
