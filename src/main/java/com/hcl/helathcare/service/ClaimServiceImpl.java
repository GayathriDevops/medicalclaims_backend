package com.hcl.helathcare.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.helathcare.dto.ClaimResponseDTO;
import com.hcl.helathcare.dto.UpdateRequestDTO;
import com.hcl.helathcare.entity.Claim;
import com.hcl.helathcare.exception.ClaimNotPresentException;
import com.hcl.helathcare.repository.ClaimRepository;

@Service
public class ClaimServiceImpl implements ClaimService {
	
	@Autowired
	ClaimRepository claimRepository;
	

	@Override
	public List<ClaimResponseDTO> viewClaims() throws Exception {
		
		String searchCriteria = "pending";
	
		Optional<List<Claim>> claims = claimRepository.findAllByClaimStatus(searchCriteria);
		
		if(!claims.isPresent())
			throw new ClaimNotPresentException("claims not present");
		
		List<Claim> claimList = claims.get();
		
		List<ClaimResponseDTO> claimResult = new ArrayList<>();
		
		claimList.forEach(claim -> {
			ClaimResponseDTO result = new ClaimResponseDTO();
			BeanUtils.copyProperties(claim, result);
			claimResult.add(result);
		});
		
		return claimResult;	
	}


	@Override
	public Claim updateClaims(UpdateRequestDTO updateRequest) throws ClaimNotPresentException{
		
		long id = updateRequest.getClaimId();
		String status = updateRequest.getStatus();
		
		Claim claim = claimRepository.findByClaimId(id);
		Optional<Claim> claims = Optional.of(claim);
		if(!claims.isPresent())
			throw new ClaimNotPresentException("claims not present");
 
		claim.setClaimStatus(status);

		Claim result = claimRepository.save(claim);
		
		return result;
		
	}
	
}
