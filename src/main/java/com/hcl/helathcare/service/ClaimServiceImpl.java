package com.hcl.helathcare.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.helathcare.dto.ClaimDetails;
import com.hcl.helathcare.dto.ClaimResponse;
import com.hcl.helathcare.dto.PloicyDetails;
import com.hcl.helathcare.dto.PolicyData;
import com.hcl.helathcare.dto.PolicyResponse;
import com.hcl.helathcare.dto.PolicyResponseDto;
import com.hcl.helathcare.entity.Claim;
import com.hcl.helathcare.entity.Policy;
import com.hcl.helathcare.exception.NoPolicyNotFound;
import com.hcl.helathcare.repository.ClaimRepository;
import com.hcl.helathcare.repository.PolicyRepository;
import com.hcl.helathcare.util.Constants;

@Service
public class ClaimServiceImpl implements ClaimService {
	
	private static final Logger logger = LoggerFactory.getLogger(ClaimServiceImpl.class);

	@Autowired
	PolicyRepository policyRepository;

	@Autowired
	ClaimRepository claimRepository;

	/*
	 * @Override public PolicyResponseDto getPolicesByUserId(Long userId) {
	 * PolicyResponseDto response = new PolicyResponseDto(); List<PloicyDetails>
	 * policsList = new ArrayList<PloicyDetails>(); List<Long> policyIds =
	 * claimRepository.getClaimsByUserId(userId);
	 * 
	 * logger.info("Policy::----------={}");
	 * 
	 * if(policyIds.size()>0) {policyIds.stream().forEach((polices) -> {
	 * PloicyDetails details = new PloicyDetails(); Policy p =
	 * policyRepository.findById(polices).get();
	 * details.setPolicyAmount(p.getPolicyAmount());
	 * details.setPolicyId(p.getPolicyId());
	 * details.setPolicyCycle(p.getPolicyCycle());
	 * details.setPolicyName(p.getPolicyName()); policsList.add(details);
	 * 
	 * });
	 * 
	 * }else { throw new NoPolicyNotFound(Constants.POLICY_NOT_FOUND); }
	 * 
	 * 
	 * response.setPolicyDetails(policsList);
	 * 
	 * return response; }
	 */
	
	@Override

    public ClaimResponse getClaimsByUser(Long userId) {
		logger.info("Claim ::----------={}");
		
	List<Claim> claimsList=	claimRepository.findByUserId(userId);
	
	ClaimResponse response= new ClaimResponse();
	
	List<ClaimDetails> cliamList= new ArrayList<ClaimDetails>();

	 claimsList.stream().forEach((c) -> {
		 
		 ClaimDetails details= new ClaimDetails();
		 details.setAdmissionDate(c.getAdmissionDate());	
		 details.setClaimAmount(c.getClaimAmount());
		 details.setClaimId(c.getClaimId());
		 details.setClaimStatus(c.getClaimStatus());
		 details.setDiagnosis(c.getDiagnosis());
		 details.setDischargeDate(c.getDischargeDate());
		 details.setFileName(c.getFileName());
		 details.setHospitalName(c.getHospitalName());
		 details.setPolicyId(c.getPolicyId());
		 details.setUserId(c.getUserId());
		 cliamList.add(details);	 
	});
	 response.setClientDetails(cliamList);
           return response;

    }

	
	@Override
	public PolicyResponse getPolicesByUserId(Long userId) {	
		logger.info("Policy ::----------={}");
		PolicyResponse response= new PolicyResponse();	
	List<Object[]> objects=	 policyRepository.getPolicesByUserId(userId);
	if(objects.size()>0)
	{List<PolicyData> polices= new ArrayList<PolicyData>();
	objects.stream().forEach((obj) -> {
		PolicyData pd= new PolicyData();
		pd.setPolicyId(Long.parseLong(obj[0].toString()));
		pd.setPolicyName(obj[1].toString());
		pd.setClaimOutstanindBalance(Double.parseDouble(obj[2].toString()));
		pd.setPolicyStartDate( LocalDate.parse(obj[3].toString()));
		pd.setPolicyEndDate( LocalDate.parse(obj[4].toString()));
		polices.add(pd);	 
	 });
	 response.setPolices(polices);	
	}else
	{
		throw new  NoPolicyNotFound(Constants.POLICY_NOT_FOUND);
	}
	
		return  response;
	}	

}
