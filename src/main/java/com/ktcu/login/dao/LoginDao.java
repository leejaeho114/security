package com.ktcu.login.dao;

import com.ktcu.member.model.UserVo;
import org.springframework.stereotype.Repository;

/**
 * Created by LG on 2017-07-24.
 */


public class LoginDao {
	public void updateLoginFailCnt(UserVo userVo){
		int loginFailCnt = userVo.getLoginFailCnt();
		userVo.setLoginFailCnt(++loginFailCnt);
	}
}
