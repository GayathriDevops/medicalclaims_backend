package com.hcl.helathcare.service;

import java.util.List;

import com.hcl.helathcare.dto.ClaimResponseDTO;
import com.hcl.helathcare.dto.UpdateRequestDTO;
import com.hcl.helathcare.entity.Claim;
import com.hcl.helathcare.exception.ClaimNotPresentException;

public interface ClaimService {

	List<ClaimResponseDTO> viewClaims() throws Exception;

	Claim updateClaims(UpdateRequestDTO updateRequest) throws ClaimNotPresentException;

}
