package com.hcl.helathcare.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PloicyDetails {
	private Long policyId;
	private String policyName;
	private double policyAmount;
	private String policyCycle;


}
