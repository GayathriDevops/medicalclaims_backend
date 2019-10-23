package com.hcl.helathcare.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * @author Pradeepa AJ
 * @version 1.0
 * @since 2019-10-22
 *
 */
@Data
@Entity
@Table(name = "claim")
public class Claim {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long claimId;
	private Long userId;
	private Long policyId;
	private LocalDate admissionDate;
	private LocalDate dischargeDate;
	private Double claimAmount;
	private String hospitalName;
	private String dischargeSummary;
	private String diagnosis;
	private String fileName;
	private String claimStatus;
}
