package com.ktcu.login.security;

import com.ktcu.login.security.exception.LoginFailCountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by LG on 2017-07-25.
 */

@ControllerAdvice
@Controller
public class SecurityExceptionController {

	@ExceptionHandler(LoginFailCountException.class)
	public ModelAndView loginFailCountException(HttpServletRequest req) {

		HttpSession session = req.getSession(false);
		session.setAttribute("loginFailCnt", 5);

		return new ModelAndView("redirect:/login");
	}

}
