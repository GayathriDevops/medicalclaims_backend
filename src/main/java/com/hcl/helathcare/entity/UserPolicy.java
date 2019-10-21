package com.hcl.helathcare.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_policy")
public class UserPolicy {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long up_id;
	private double claimOutstatnindBalance;
	private Long policyId;
	private Long userId;
	private LocalDate endDate;
	private LocalDate startDate;
	private LocalDate policyEndDate;
	private LocalDate policyStartDate;
	
	
}
