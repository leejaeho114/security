package com.ktcu.login.security;

import com.google.gson.Gson;
import com.ktcu.login.domain.LoginResult;
import com.ktcu.login.domain.LoginUser;
import com.ktcu.login.service.LoginService;
import com.ktcu.member.model.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

/**
 * Created by LG on 2017-07-25.
 */

@Component("authSuccessHandler")
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Autowired LoginService loginService;

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		loginUser.getUserVo();

		Collection authorities = authentication.getAuthorities();
		/*boolean tobeAuthorized = authorities.contains(new SimpleGrantedAuthority("ROLE_USER"));*/
		boolean asisAuthorized = authorities.contains(new SimpleGrantedAuthority("ROLE_ASIS_USER"));
		String returnUrl = asisAuthorized ? "/asisIndex" : "index";

		//todo login count reset
		loginService.updateLoginFailCnt(UserVo.getUserVo(), 0);

		//todo ip check

		//super.onAuthenticationSuccess(request, response, authentication);
		LoginResult resultVo = new LoginResult();

		resultVo.setCode("200");
		resultVo.setMessage("login success.");
		resultVo.setReturnUrl(returnUrl);

		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(resultVo));
		out.flush();
		out.close();
	}
}
