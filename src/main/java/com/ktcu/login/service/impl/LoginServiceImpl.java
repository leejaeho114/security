package com.ktcu.login.service.impl;

import com.ktcu.login.dao.LoginDao;
import com.ktcu.login.service.LoginService;
import com.ktcu.member.model.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LG on 2017-07-24.
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService{

	@Override
	public void updateLoginFailCnt(UserVo userVo) {
		LoginDao loginDao = new LoginDao();
		loginDao.updateLoginFailCnt(userVo);
	}
}
