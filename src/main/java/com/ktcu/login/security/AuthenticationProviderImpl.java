package com.ktcu.login.security;

import com.ktcu.login.domain.LoginUser;
import com.ktcu.login.security.exception.AsisUserPasswordFailureException;
import com.ktcu.login.security.exception.TobeUserPasswordFailureException;
import com.ktcu.login.service.LoginService;
import com.ktcu.member.model.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * ???? ??
 * Created by LG on 2017-07-24.
 */
@Component("authProvider")
public class AuthenticationProviderImpl implements AuthenticationProvider {

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationProviderImpl.class);

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private LoginService loginService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getName();
		String password = (String)authentication.getCredentials();
		LoginUser user = null;

		UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
		if(userDetails != null) {
			user = (LoginUser)userDetails;
			UserVo userVo = user.getUserVo();

			if(user == null) {
				logger.debug(user.getUsername());
				throw new UsernameNotFoundException("id & password is not correct");
			}

			/* todo password encrypt
			String encPassword = ssha.createDigest(ssha.getCommonSalt(), password);
			if (!encPassword.equals(user.getPassword())) {
				logger.debug(user.getPassword());
				throw new UsernameNotFoundException("???? ????? ???? ?? ???? ???.");
			}*/

			String encPassword = password;
			if (userVo.isTobeUser() && !encPassword.equals(user.getPassword())) {
				logger.debug(user.getPassword());
				throw new TobeUserPasswordFailureException("id & password is not correct", userVo);

			}else if (!userVo.isTobeUser() && !encPassword.equals(user.getPassword())) {
				logger.debug(user.getPassword());
				throw new AsisUserPasswordFailureException("id & password is not correct", userVo);
			}
		}
		return new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return true;
	}
}
