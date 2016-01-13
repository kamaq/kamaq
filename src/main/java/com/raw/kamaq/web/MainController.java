package com.raw.kamaq.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.raw.kamaq.model.Component;
import com.raw.kamaq.service.ApplicationService;

@Controller
public class MainController {

	private final ApplicationService applicationService;

	@Autowired
	public MainController(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@RequestMapping(value = "/main/options", method = RequestMethod.POST)
	public ModelAndView processValidationUser() {

		Collection<Component> components = this.applicationService.getComponentList();
		ModelAndView model = new ModelAndView("/main/menu");
		model.addObject("components", components);
		return model;

	}

	@RequestMapping(value = "/main/moduleForm", method = RequestMethod.GET)
	public ModelAndView openModuleForm() {

		Collection<Component> components = this.applicationService.getComponentList();
		ModelAndView model = new ModelAndView("/form/moduleForm");
		model.addObject("components", components);
		return model;

	}

	@RequestMapping(value = "/main/componentForm", method = RequestMethod.GET)
	public ModelAndView openComponentForm() {

		Collection<Component> components = this.applicationService.getComponentList();
		ModelAndView model = new ModelAndView("/form/componentForm");
		model.addObject("components", components);
		return model;

	}

}
