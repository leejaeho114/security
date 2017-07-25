package com.ktcu.login.controller;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by LG on 2017-07-24.
 */

@Controller
public class LoginController {


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() throws UsernameNotFoundException {

		ModelAndView model = new ModelAndView();
		model.setViewName("/login/login");
		return model;
	}
}
