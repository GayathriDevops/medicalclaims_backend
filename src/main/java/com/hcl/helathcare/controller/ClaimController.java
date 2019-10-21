package com.hcl.helathcare.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.helathcare.dto.ClaimResponseDTO;
import com.hcl.helathcare.dto.UpdateRequestDTO;
import com.hcl.helathcare.dto.UpdateResponseDTO;
import com.hcl.helathcare.dto.ViewClaimsDTO;
import com.hcl.helathcare.exception.ClaimNotPresentException;
import com.hcl.helathcare.service.ClaimService;
import com.hcl.helathcare.util.Constants;

@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class ClaimController {
	private static final Logger logger = LoggerFactory.getLogger(ClaimController.class);

	@Autowired
	ClaimService claimService;
	
	@GetMapping("/admin/claims")
	public ResponseEntity<ViewClaimsDTO> viewClaims() throws Exception {

		List<ClaimResponseDTO> viewClaims = claimService.viewClaims();

		ViewClaimsDTO claimsList = new ViewClaimsDTO();
		claimsList.setViewClaims(viewClaims);

		return new ResponseEntity<>(claimsList, HttpStatus.OK);

	}

	@PutMapping("/admin/claims")
	public ResponseEntity<UpdateResponseDTO> updateClaims(@RequestBody UpdateRequestDTO updateRequest)
			throws ClaimNotPresentException {

		claimService.updateClaims(updateRequest);

		UpdateResponseDTO response = new UpdateResponseDTO();
		response.setMessage(Constants.UPDATE_SUCCESS_MESSAGE);
		response.setStatusCode(Constants.OK);

		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	
	

}
