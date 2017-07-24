package com.ktcu.login.domain;

import com.ktcu.member.model.UserVo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by LG on 2017-07-24.
 */
public class LoginUser extends User {
	private UserVo userVo;

	public LoginUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public LoginUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

	public UserVo getUserInfo(){
		return userVo;
	};

	public void setUserVo(UserVo userVo){
		this.userVo = userVo;
	}
}
