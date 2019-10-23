package com.hcl.helathcare.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.hcl.helathcare.dto.ClaimReqDto;
import com.hcl.helathcare.dto.ResponseDto;
import com.hcl.helathcare.exception.InvalidClaimAmountException;
import com.hcl.helathcare.exception.PolicyNotExistsException;
import com.hcl.helathcare.exception.UserNotExistsException;
import com.hcl.helathcare.service.ClaimService;

/**
 * implemented creating new claim controller test case
 * 
 * @author Pradeepa AJ
 * @version 1.0
 * @since 2019-10-22
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class ClaimControllerTest {

	@Mock
	private ClaimService claimService;

	@InjectMocks
	private ClaimController claimController;

	private ClaimReqDto claimReq;
	private ResponseDto response;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		claimReq = ClaimReqDto.builder().userId(1L).policyId(1L).claimAmount(5000.0).build();
		response = ResponseDto.builder().message("claim Success").statusCode(201).build();

	}

	/**
	 * @param Nothing
	 * @return Nothing
	 * @throws UserNotExistsException
	 * @throws InvalidClaimAmountException
	 * @throws PolicyNotExistsException
	 * 
	 */
	@Test
	public void createNewClaimTest() throws UserNotExistsException, InvalidClaimAmountException, PolicyNotExistsException {
		Mockito.when(claimService.createNewClaim(claimReq)).thenReturn(response);
		ResponseEntity<ResponseDto> actRes = claimController.createNewClaim(claimReq);
		assertEquals(201, actRes.getStatusCode().value());
	}

}
