package com.hcl.helathcare.dto;

import lombok.Builder;

/**
 * 
 * @author Pradeepa AJ
 *
 */
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Pradeepa AJ
 * @version 1.0
 * @since 2019-10-22
 *
 */
@Builder
@Getter
@Setter
public class LoginResDto {
	private Long userId;
	private int statusCode;
	private String message;
	private Long roleId;
}
