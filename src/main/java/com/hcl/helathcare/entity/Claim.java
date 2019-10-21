package com.hcl.helathcare.entity;

import java.io.File;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "claim")
public class Claim {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
