package com.hcl.helathcare.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import com.hcl.helathcare.dto.ClaimResponseDTO;
import com.hcl.helathcare.entity.Claim;
import com.hcl.helathcare.repository.ClaimRepository;


@RunWith(MockitoJUnitRunner.class)
public class ClaimServiceImplTest {

	@Mock
	ClaimRepository claimRepository;

	@InjectMocks
	ClaimServiceImpl claimServiceImpl;
	
	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);
		
		Claim claim = new Claim();
		claim.setUserId(1L);
		claim.setAdmissionDate(LocalDate.now());
		claim.setClaimAmount(20000D);
		claim.setClaimStatus("pending");
		claim.setDiagnosis("jhfjvhks");
		claim.setDischargeDate(LocalDate.now());
		claim.setFileName("file");
		claim.setHospitalName("appolo");
		claim.setPolicyId(1L);
		claim.setClaimAmount(100D);	
		
	}


	
	@Test
	public void testViewClaims() throws Exception {
		
		List<Claim> claims = new ArrayList<>();
	
		Optional<List<Claim>> claimList = Optional.of(claims);

		Mockito.when(claimRepository.findAllByClaimStatus(Mockito.anyString())).thenReturn(claimList);
		
		List<ClaimResponseDTO> viewClaims = claimServiceImpl.viewClaims();
	
		assertNotNull(viewClaims);
		assertEquals("pending", viewClaims.get(0).getClaimStatus());
	}


	
	/*
	 * @Test(expected = BookNotPresentException.class)
	 * 
	 * public void BookNotPresentExceptionTest() {
	 * 
	 * Mockito.when(bookRepository.findByBookNameOrAuthorName(Mockito.anyString())).
	 * thenReturn(Optional.ofNullable(null));
	 * 
	 * List<BookResponseDTO> searchBooks =
	 * BookServiceImpl.searchBooks(Mockito.any()); assertNotNull(searchBooks);
	 * assertEquals(0, searchBooks.size());
	 * 
	 * }
	 */
}
