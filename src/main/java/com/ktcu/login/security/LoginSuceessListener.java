package com.ktcu.login.security;

import com.ktcu.login.service.LoginService;
import com.ktcu.member.model.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by LG on 2017-07-25.
 */
public class LoginSuceessListener implements ApplicationListener<AuthenticationSuccessEvent> {


	@Autowired
	LoginService loginService;

	@Override
	public void onApplicationEvent(AuthenticationSuccessEvent authenticationSuccessEvent) {
		UserDetails userDetails = ((UserDetails)(authenticationSuccessEvent.getAuthentication().getPrincipal()));

		//loginService.updateLoginFailCnt();
	}
}
