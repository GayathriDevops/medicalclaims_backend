package com.hcl.helathcare.service;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hcl.helathcare.dto.LoginReqDto;
import com.hcl.helathcare.dto.LoginResDto;
import com.hcl.helathcare.repository.UserRepository;
import com.hcl.helathcare.util.Constants;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class LoginServiceImplTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private LoginServiceImpl loginServiceImpl;
	
	 LoginReqDto loginReq;
	 LoginResDto loginRes; 
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		
		loginReq = LoginReqDto.builder().email("Pradeep.aj28@gmail.com").password("Pradeep").build();
		loginRes = LoginResDto.builder().message(Constants.LOG_SUCCESS_MESSAGE).statusCode(Constants.OK).userId(1L).roleId(1L)
				.build();
		
		
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
