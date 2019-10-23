package com.hcl.helathcare.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * else thrwing exception if valid claim will send claim id and status through mail
 * 
 * @author Pradeepa AJ
 * @version 1.0
 * @since 2019-10-22
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

	private static final Logger logger = LoggerFactory.getLogger(ClaimServiceImpl.class);

	/**
	 * * Method will validate user, policy, claim amount it is valid it will create
	 * new claim else throw exception and sending claim status and Claim number
	 * through Mail
	 * 
	 * 
	 * @param request NotNull
	 * @return ResponseDto
	 * @throws UserNotExistsException
	 * @throws InvalidClaimAmountException
	 * @throws PolicyNotExistsException
	 */
	@Override
	public ResponseDto createNewClaim(ClaimReqDto request)
			throws UserNotExistsException, InvalidClaimAmountException, PolicyNotExistsException {
		Optional<User> userExists = userRepository.findById(request.getUserId());
		if (userExists.isPresent()) {
			logger.info(":: Valid User-----:{}=", request.getUserId());
			Optional<Policy> policyExists = policyRepository.findById(request.getPolicyId());
			if (policyExists.isPresent()) {
				logger.info(":: Valid Policy--------:{}=", request.getUserId());
				Optional<UserPolicy> userPolicyEXistts = userPolicyRepository
						.findByPolicyIdAndUserId(request.getPolicyId(), request.getUserId());
				if (userPolicyEXistts.isPresent()

						&& request.getClaimAmount() <= userPolicyEXistts.get().getClaimOutstatnindBalance()) {
					logger.info("::Valid User Policy and Claim Amount-----:{}=", request.getClaimAmount());
					Claim claim = new Claim();
					BeanUtils.copyProperties(request, claim);
					claim.setClaimStatus(Constants.CLAIM_STATUS);
					claimRepository.save(claim);
					mailWithOTPService.sendEmail(userExists.get().getEmail(), Constants.CLAIM_MAIL_SUBJECT,
							Constants.CLAIM_MAIL_BODY + claim.getClaimId());
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
