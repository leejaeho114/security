package com.ktcu.login.security;

import com.google.gson.Gson;
import com.ktcu.login.domain.LoginResult;
import com.ktcu.login.security.exception.TobeUserPasswordFailureException;
import com.ktcu.login.service.LoginService;
import com.ktcu.member.model.UserVo;
import nl.captcha.Captcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
import java.io.PrintWriter;

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
		Class exceptionClass = exception.getClass();

		if(exceptionClass.isAssignableFrom(UsernameNotFoundException.class)){

		} else if(exceptionClass.isAssignableFrom(TobeUserPasswordFailureException.class)){
			TobeUserPasswordFailureException ex = (TobeUserPasswordFailureException)exception;
			UserVo userVo = ex.getUserVo();

			loginService.updateLoginFailCnt(userVo);

			HttpSession session = request.getSession(false);
			session.setAttribute("loginFailCnt", userVo.getLoginFailCnt());

		}

		LoginResult resultVo = new LoginResult();

		resultVo.setCode("200");
		resultVo.setMessage("login fail.");
		resultVo.setReturnUrl("/index");

		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(resultVo));
		out.flush();
		out.close();

	}
}
