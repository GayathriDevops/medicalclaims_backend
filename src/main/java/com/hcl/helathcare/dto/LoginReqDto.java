package com.hcl.helathcare.dto;

import lombok.Builder;
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
public class LoginReqDto {

	private String email;

	private String password;

}
