package com.hcl.helathcare.service;


import com.hcl.helathcare.dto.ClaimResponse;


public interface ClaimService {

	/* public PolicyResponseDto getPolicesByUserId(Long userId); */
	public ClaimResponse getClaimsByUser(Long userId);
}
