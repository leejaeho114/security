package com.ktcu.login.security;

import com.ktcu.login.domain.LoginUser;
import com.ktcu.member.model.UserVo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * user ?? ??
 * Created by LG on 2017-07-24.
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		//todo DB select
		UserVo userVO = new UserVo().getTobeUserVo();

		if(!userVO.getId().equals(username)){
			throw new UsernameNotFoundException("id & password is not correct");
		}

		if(userVO.getLoginFailCnt() == 5){
			//throw new UsernameNotFoundException("id & password is not correct");
		}

		if(userVO.getAsisId() != null){
			throw new UsernameNotFoundException("id & password is not correct");
		}

		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

		//LoginUser user = new LoginUser(userVO.getId(), userVO.getPassword(), authorities);
		LoginUser user = new LoginUser(userVO.getId(), userVO.getPassword(), true, true, true, true, authorities);
		user.setUserVo(userVO);

		return user;
	}
}
