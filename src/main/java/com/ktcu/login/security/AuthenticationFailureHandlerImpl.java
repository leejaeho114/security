package com.ktcu.login.security;

import com.ktcu.login.service.LoginService;
import com.ktcu.member.model.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by LG on 2017-07-25.
 */
@Component("authFailureHandler")
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Autowired
	LoginService loginService;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		String url = "/login";

		HttpSession session = request.getSession(false);
		if(session != null) {
			session.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception.getMessage());
		}

		session.setAttribute("loginFailCnt", 5);


		//UserVo userVo = UserVo.getUserVo();

		//loginService.updateLoginFailCnt(userVo);

		redirectStrategy.sendRedirect(request, response, url);
	}
}
