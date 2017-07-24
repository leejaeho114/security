package com.ktcu.login.service.impl;

import com.ktcu.login.dao.LoginDao;
import com.ktcu.login.service.LoginService;
import com.ktcu.member.model.UserVo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by LG on 2017-07-24.
 */
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginDao loginDao;

	@Override
	public void updateLoginFailCnt(UserVo userVo) {
		loginDao.updateLoginFailCnt(userVo);
	}
}
