package com.hcl.helathcare.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * @author Pradeep AJ
 *
 */
@Data
@Entity
@Table(name = "user_policy")
public class UserPolicy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long upId;
	private Long userId;
	private Long policyId;
	private Double claimOutstatnindBalance;
	

}
