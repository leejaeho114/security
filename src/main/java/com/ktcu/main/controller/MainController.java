package com.ktcu.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by LG on 2017-07-24.
 */
@Controller
public class MainController {

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
}
