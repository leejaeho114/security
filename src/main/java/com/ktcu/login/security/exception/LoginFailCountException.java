package com.ktcu.login.security.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by LG on 2017-07-25.
 */
public class LoginFailCountException extends UsernameNotFoundException {

	public LoginFailCountException(String msg, Throwable t) {
		super(msg, t);
	}

	public LoginFailCountException(String msg) {

		super(msg);
	}


}
