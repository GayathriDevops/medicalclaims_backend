package com.hcl.helathcare.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.helathcare.dto.ResponseDto;

@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class ClaimController {
	private static final Logger logger = LoggerFactory.getLogger(ClaimController.class);
	
	@Autowired
	private ClaimService claimService;
	
	public ResponseEntity<ResponseDto> createNewClaim(@RequestBody ClaimReqDto request){
		return new ResponseEntity<>()
		
	}
	

}
