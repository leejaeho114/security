package com.ktcu.main.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by LG on 2017-07-24.
 */
@Controller
public class MainController {

	@Secured("ROLE_USER")
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {

		ModelAndView model = new ModelAndView();
		model.setViewName("/index");
		return model;
	}

	@RequestMapping(value = "/index2", method = RequestMethod.GET)
	public ModelAndView index2() {

		ModelAndView model = new ModelAndView();
		model.setViewName("/index2");
		return model;
	}

	@Secured("ROLE_ASIS_USER")
	@RequestMapping(value = "/asisIndex", method = RequestMethod.GET)
	public ModelAndView asisIndex() {

		ModelAndView model = new ModelAndView();
		model.setViewName("/asisIndex");
		return model;
	}
}
