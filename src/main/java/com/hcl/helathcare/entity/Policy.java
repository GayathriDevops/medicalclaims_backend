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
@Table(name = "policy")
public class Policy {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long policyId;
	private String policyName;
	private double policyAmount;
	private String policyCycle;

}
