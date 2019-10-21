package com.hcl.helathcare.serviceTest;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.helathcare.dto.ClaimDetails;
import com.hcl.helathcare.dto.ClaimResponse;
import com.hcl.helathcare.entity.Claim;
import com.hcl.helathcare.repository.ClaimRepository;
import com.hcl.helathcare.service.ClaimServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ClaimServiceTest {
	
	@InjectMocks
	ClaimServiceImpl claimServiceImpl;
	
	@Mock
	ClaimRepository claimRepository;

	
	@Test
	public void createBeneficiaryTest() {
		ClaimDetails cl= new ClaimDetails();
		Claim c= new Claim();
		List<ClaimDetails> claims= new ArrayList<ClaimDetails>();
		cl.setAdmissionDate(LocalDate.now());
		cl.setClaimAmount(10000);
		cl.setClaimId(1L);
		cl.setClaimStatus("Approved");
		cl.setDiagnosis("Cardio");
		cl.setDischargeDate(LocalDate.now());
		cl.setDischargeSummary("ffff");
		cl.setFileName(null);
		cl.setHospitalName("Appollo");
		cl.setPolicyId(1L);
		cl.setUserId(1L);
		claims.add(cl);
		
		List<Claim> cList= new ArrayList<Claim>();
		c.setAdmissionDate(LocalDate.now());
		c.setClaimAmount(10000);
		c.setClaimId(1L);
		c.setClaimStatus("Approved");
		c.setDiagnosis("Cardio");
		c.setDischargeDate(LocalDate.now());
		c.setDischargeSummary("ffff");
		c.setFileName(null);
		c.setHospitalName("Appollo");
		c.setPolicyId(1L);
		c.setUserId(1L);
		cList.add(c);
		
		
		ClaimResponse cla= new ClaimResponse(); 
		cla.setClientDetails(claims);
		  Mockito.when(claimServiceImpl.getClaimsByUser(1L)).thenReturn(cla);
		  Mockito.when(claimRepository.findByUserId(1L)).thenReturn(cList);
		 
		assertEquals(claimRepository.findByUserId(1L).size(),1);
	}

	
	
}
