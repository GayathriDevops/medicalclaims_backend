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
@Table(name = "user_policy")
public class UserPolicy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long upId;
	private Long userId;
	private Long policyId;
	private Double claimOutstatnindBalance;
	private LocalDate policyStartDate;
	private LocalDate policyEndtDate;

}
