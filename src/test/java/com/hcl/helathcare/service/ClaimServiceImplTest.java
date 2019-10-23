package com.hcl.helathcare.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.hcl.helathcare.dto.ClaimReqDto;
import com.hcl.helathcare.dto.ResponseDto;
import com.hcl.helathcare.entity.Claim;
import com.hcl.helathcare.entity.Policy;
import com.hcl.helathcare.entity.User;
import com.hcl.helathcare.entity.UserPolicy;
import com.hcl.helathcare.exception.InvalidClaimAmountException;
import com.hcl.helathcare.exception.PolicyNotExistsException;
import com.hcl.helathcare.exception.UserNotExistsException;
import com.hcl.helathcare.repository.ClaimRepository;
import com.hcl.helathcare.repository.PolicyRepository;
import com.hcl.helathcare.repository.UserPolicyRepository;
import com.hcl.helathcare.repository.UserRepository;
import com.hcl.helathcare.util.MailWithOTPService;

/**
 * implemented creating new claim service implementation test case
 * 
 * @author Pradeepa AJ
 * @version 1.0
 * @since 2019-10-22
 *
 */
@RunWith(MockitoJUnitRunner.Silent.class)
public class ClaimServiceImplTest {

	@Mock
	private ClaimRepository claimRepository;

	@Mock
	private PolicyRepository policyRepository;
	@Mock
	private UserRepository userRepository;
	@Mock
	private UserPolicyRepository userPolicyRepository;
	@Mock
	private MailWithOTPService mailWithOTPService;

	@InjectMocks
	private ClaimServiceImpl claimServiceImpl;

	private ClaimReqDto claimReq;
	private ClaimReqDto negclaimReq;
	private Claim claim;
	private User user;
	private Policy policy;
	private UserPolicy userPolicy;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		user = new User();
		user.setUserId(1L);
		user.setEmail("pradeep.aj28@gmail.com");
		user.setPassword("pradeep");
		policy = new Policy();
		policy.setPolicyId(1L);
		policy.setPolicyName("eye");
		policy.setPolicyAmount(200000.0);
		userPolicy = new UserPolicy();
		userPolicy.setUpId(1L);
		userPolicy.setClaimOutstatnindBalance(10000.0);
		userPolicy.setPolicyId(1L);
		userPolicy.setUserId(1L);
		claim = new Claim();
		claimReq = ClaimReqDto.builder().userId(1L).policyId(1L).claimAmount(5000.0).build();
		negclaimReq = ClaimReqDto.builder().userId(1L).build();
		BeanUtils.copyProperties(claimReq, claim);
		claim.setClaimStatus("Pending");
		claim.setClaimId(1L);

	}

	/**
	 * @param Nothing
	 * @return Nothing
	 * @throws UserNotExistsException
	 * @throws InvalidClaimAmountException
	 * @throws PolicyNotExistsException
	 */

	@Test
	public void createNewClaimTest()
			throws UserNotExistsException, InvalidClaimAmountException, PolicyNotExistsException {
		Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
		Mockito.when(policyRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(policy));
		Mockito.when(userPolicyRepository.findByPolicyIdAndUserId(Mockito.anyLong(), Mockito.anyLong()))
				.thenReturn(Optional.of(userPolicy));
		Mockito.when(claimRepository.save(claim)).thenReturn(claim);
		mailWithOTPService.sendEmail("Pradeep.aj28@gmail.com", "Mail", "Mail");
		ResponseDto actRes = claimServiceImpl.createNewClaim(claimReq);
		assertEquals(201, actRes.getStatusCode());
	}

	/**
	 * negative test cases for craeteNewClaim
	 * 
	 * @param Nothing
	 * @return Nothing
	 * @throws UserNotExistsException
	 */
	@Test(expected = UserNotExistsException.class)
	public void userNotExistsExceptionTest()
			throws UserNotExistsException, InvalidClaimAmountException, PolicyNotExistsException {
		claimServiceImpl.createNewClaim(claimReq);
	}

	/**
	 * negative test cases for craeteNewClaim
	 * 
	 * @param Nothing
	 * @return Nothing
	 * @throws PolicyNotExistsException
	 */
	@Test(expected = PolicyNotExistsException.class)
	public void policyNotExistsExceptionTest()
			throws UserNotExistsException, InvalidClaimAmountException, PolicyNotExistsException {
		Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
		claimServiceImpl.createNewClaim(negclaimReq);
	}

	/**
	 * negative test cases for craeteNewClaim
	 * 
	 * @param Nothing
	 * @return Nothing
	 * @throws InvalidClaimAmountException
	 */
	@Test(expected = InvalidClaimAmountException.class)
	public void invalidClaimAmountExceptionTest()
			throws UserNotExistsException, InvalidClaimAmountException, PolicyNotExistsException {
		Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
		Mockito.when(policyRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(policy));
		claimServiceImpl.createNewClaim(claimReq);
	}

}
