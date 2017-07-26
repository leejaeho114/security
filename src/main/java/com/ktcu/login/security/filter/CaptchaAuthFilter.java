package com.ktcu.login.security.filter;

import com.google.gson.Gson;
import com.ktcu.login.domain.LoginResult;
import com.ktcu.login.domain.LoginUser;
import com.ktcu.member.model.UserVo;
import nl.captcha.Captcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by leejaeho on 2017. 7. 25..
 */
@Component("captchaAuthFilter")
public class CaptchaAuthFilter extends OncePerRequestFilter{

	@Autowired
	private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

		String id = request.getParameter("id");
		boolean isNextFilterChain = true;

		if(id != null){
			UserDetails userDetails = userDetailsService.loadUserByUsername(id);
			if(userDetails != null) {
				LoginUser user = (LoginUser)userDetails;
				UserVo userVo = user.getUserVo();
				int loginFailCnt = userVo.getLoginFailCnt();

				if(loginFailCnt == 5){

					HttpSession session = request.getSession(false);
					Captcha captcha = (Captcha)session.getAttribute(Captcha.NAME);
					session.setAttribute("loginFailCnt", loginFailCnt);

					if(captcha == null){
						isNextFilterChain = false;
						//response.sendRedirect("/login");

						LoginResult resultVo = new LoginResult();

						resultVo.setCode("400");
						resultVo.setMessage("need captcha.");
						resultVo.setReturnUrl("/login");

						Gson gson = new Gson();
						PrintWriter out = response.getWriter();
						out.print(gson.toJson(resultVo));
						out.flush();
						out.close();

					}else{
						String answer = request.getParameter("answer");
						if(!captcha.isCorrect(answer)){
							isNextFilterChain = false;

							LoginResult resultVo = new LoginResult();

							resultVo.setCode("401");
							resultVo.setMessage("not correct captcha.");
							//resultVo.setReturnUrl("/login");

							Gson gson = new Gson();
							PrintWriter out = response.getWriter();
							out.print(gson.toJson(resultVo));
							out.flush();
							out.close();

							//throw new CaptchaNotEqualException("????? ??????.");
						}
					}
				}
			}

		}

		if(isNextFilterChain){
			filterChain.doFilter(request, response);
		}
    }
}
