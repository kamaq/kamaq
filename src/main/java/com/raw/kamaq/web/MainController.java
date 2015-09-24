package com.raw.kamaq.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.raw.kamaq.service.ApplicationService;

@Controller
public class MainController {

	private final ApplicationService applicationService;

	@Autowired
	public MainController(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@RequestMapping(value = "/main/menu", method = RequestMethod.GET)
	public ModelAndView processValidationUser() {

		ModelAndView model = new ModelAndView("/main/menu");
		return model;

	}

}
