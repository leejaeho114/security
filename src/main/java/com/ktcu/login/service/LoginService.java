package com.ktcu.login.service;

import com.ktcu.member.model.UserVo;
import org.springframework.stereotype.Service;

/**
 * Created by LG on 2017-07-24.
 */

public interface LoginService {
	public void updateLoginFailCnt(UserVo userVo);
}
