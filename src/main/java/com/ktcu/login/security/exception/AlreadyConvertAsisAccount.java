package com.ktcu.login.security.exception;

import com.ktcu.member.model.UserVo;
import org.springframework.security.core.AuthenticationException;

public class AlreadyConvertAsisAccount extends AuthenticationException {
	private UserVo userVo;

	public UserVo getUserVo() {
		return userVo;
	}

	public void setUserVo(UserVo userVo) {
		this.userVo = userVo;
	}

	public AlreadyConvertAsisAccount(String msg) {
		super(msg);
	}

	public AlreadyConvertAsisAccount(String msg, UserVo userVo) {
		super(msg);
		this.setUserVo(userVo);

	}

	public AlreadyConvertAsisAccount(String msg, Throwable t) {
		super(msg, t);
	}
}
