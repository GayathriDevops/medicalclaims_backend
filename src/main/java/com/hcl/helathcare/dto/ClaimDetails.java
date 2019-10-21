package com.hcl.helathcare.dto;

import java.io.File;
import java.time.LocalDate;

import lombok.Data;

@Data
public class ClaimDetails {
	
	private Long claimId;
	private LocalDate admissionDate;
	private double claimAmount;
	private String claimStatus;
	private String diagnosis;
	private LocalDate dischargeDate;
	private String dischargeSummary;
	private File fileName;
	private String hospitalName;
	private Long policyId;
	private Long userId;
	
}
