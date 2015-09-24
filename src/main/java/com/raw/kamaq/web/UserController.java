package com.raw.kamaq.web;

import java.util.Collection;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.raw.kamaq.model.User;
import com.raw.kamaq.service.ApplicationService;

@Controller
@SessionAttributes(types = User.class)
public class UserController {

	private final ApplicationService applicationService;
	private SessionLocaleResolver localeResolver;

	@Autowired
	public UserController(ApplicationService applicationService, SessionLocaleResolver localeResolver) {
		this.applicationService = applicationService;
		this.localeResolver = localeResolver;
	}

	@RequestMapping(value = "/users/authenticate", method = RequestMethod.POST)
	public ModelAndView processValidationUser(@RequestParam(value = "language") String language,
			@RequestParam(value = "username") String name, @RequestParam(value = "password") String password,
			SessionStatus status, Locale locale, HttpServletRequest request, HttpServletResponse response) {

		localeResolver.setLocale(request, response, new Locale(language));

		Collection<User> results = this.applicationService.authenticateUser(name, password);
		if (results.size() < 1) {
			return new ModelAndView("/login/login");
		} else {
			status.setComplete();
			User user = results.iterator().next();
			ModelAndView model = new ModelAndView("/main/welcome");
			model.addObject("msg", user.getEmail());
			return model;
		}
	}

	@RequestMapping(value = "/users/new", method = RequestMethod.POST)
	public String processCreationUser(SessionStatus status) {
		User user = new User();
		user.setName("san");
		this.applicationService.saveUser(user);
		status.setComplete();

		System.out.println("usuario: " + (this.applicationService.findUserById(1)).getName());
		return "/main/welcome";
	}
}
