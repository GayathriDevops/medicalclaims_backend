package com.hcl.helathcare.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.hcl.helathcare.util.Constants;
import com.hcl.helathcare.util.MailWithOTPService;

/**
 * override all abstracts methods from ClaimService createNewClaim- it will
 * validate user,policy, oustatnding policy amount if is valid it will creae
 * else thrwing exception
 * 
 * @author Pradeep AJ
 *
 */

@Service
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	private ClaimRepository claimRepository;

	@Autowired
	private PolicyRepository policyRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserPolicyRepository userPolicyRepository;
	@Autowired
	private MailWithOTPService mailWithOTPService;

	/**
	 * Method will validate user, policy, claim amount it is valid it will create
	 * new claim else throw exception
	 * 
	 * @param-ClaimReqDto
	 * @return-ResponseDto
	 * @exception-UserNotExistsException, InvalidClaimAmountException,
	 *                                    PolicyNotExistsException
	 */
	@Override
	public ResponseDto createNewClaim(ClaimReqDto request)
			throws UserNotExistsException, InvalidClaimAmountException, PolicyNotExistsException {
		Optional<User> userExists = userRepository.findById(request.getUserId());
		if (userExists.isPresent()) {
			Optional<Policy> policyExists = policyRepository.findById(request.getPolicyId());
			if (policyExists.isPresent()) {
				Optional<UserPolicy> userPolicyEXistts = userPolicyRepository.findByPolicyIdAndUserId(request.getPolicyId(),request.getUserId());
				if (request.getClaimAmount() <= userPolicyEXistts.get().getClaimOutstatnindBalance()) {
					Claim claim = new Claim();
					BeanUtils.copyProperties(request, claim);
					claim.setClaimStatus(Constants.CLAIM_STATUS);
					claimRepository.save(claim);
					mailWithOTPService.sendEmail(userExists.get().getEmail(), Constants.CLAIM_MAIL_SUBJECT, Constants.CLAIM_MAIL_BODY+claim.getClaimId());
					return ResponseDto.builder().message(Constants.CLAIM_SUCCESS_MESSAGE).statusCode(Constants.CREATED)
							.build();

				} else {
					throw new InvalidClaimAmountException(Constants.INVALID_CLAIM_AMOUNT);
				}

			} else {
				throw new PolicyNotExistsException(Constants.POLICY_NOT_EXISTS);
			}
		} else {
			throw new UserNotExistsException(Constants.USER_NOT_EXISTS);
		}

	}

}
