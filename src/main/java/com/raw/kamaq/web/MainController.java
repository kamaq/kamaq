package com.raw.kamaq.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.raw.kamaq.model.Component;
import com.raw.kamaq.model.Module;
import com.raw.kamaq.model.User;
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

	@RequestMapping(value = "/main/form", method = RequestMethod.GET)
	public ModelAndView openForm(@RequestParam(value = "formName") String fornName) {

		ModelAndView model = new ModelAndView("/form/" + fornName);

		if (fornName.equalsIgnoreCase("userForm")) {
			Collection<User> objects = this.applicationService.getUserList();
			model.addObject("objects", objects);
		}
		if (fornName.equalsIgnoreCase("moduleForm")) {
			Collection<Module> objects = this.applicationService.getModuleList();
			model.addObject("objects", objects);
		}
		if (fornName.equalsIgnoreCase("componentForm")) {
			Collection<Component> objects = this.applicationService.getComponentList();
			model.addObject("objects", objects);
		}
		if (fornName.equalsIgnoreCase("functionForm")) {
			Collection<Component> objects = this.applicationService.getComponentList();
			model.addObject("objects", objects);
		}

		return model;

	}

}
