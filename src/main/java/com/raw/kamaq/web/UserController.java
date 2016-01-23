package com.raw.kamaq.web;

import java.util.Collection;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.raw.kamaq.model.User;
import com.raw.kamaq.service.ApplicationService;
import com.raw.kamaq.util.DataTableConverter;

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

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
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

	@RequestMapping(value = "/users/new", method = RequestMethod.GET)
	public String initCreationForm(Model model) {
		User user = new User();

		String[] cols = { "name", "email", "password", "enabled" };
		DataTableConverter tObject = new DataTableConverter(user, cols);
		model.addAttribute("tObject", tObject);

		model.addAttribute(user);
		return "users/createOrUpdateUserForm";
	}

	@RequestMapping(value = "/users/new", method = RequestMethod.POST)
	public String processCreationUser(@Valid User user, BindingResult result, SessionStatus status, Model model,
			@RequestParam(value = "action", required = true) String action) {
		String resp = "";

		switch (action) {
		case "insert":
			if (result.hasErrors()) {
				String[] cols = { "name", "email", "password", "enabled" };
				DataTableConverter tObject = new DataTableConverter(user, cols);
				model.addAttribute("tObject", tObject);
				resp = "users/createOrUpdateUserForm";
			} else {
				this.applicationService.saveUser(user);
				status.setComplete();
				resp = "redirect:/users/" + user.getId();
			}
			break;
		case "cancel":
			resp = "redirect:/users/";
			break;
		}
		return resp;

	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String processFindForm(User user, BindingResult result, Model model) {

		Collection<User> results = this.applicationService.findUserByName("");

		if (results.size() > 1) {
			// multiple users found
			model.addAttribute("selections", results);
			String[] cols = { "id", "name", "email", "password", "enabled" };
			DataTableConverter tResults = new DataTableConverter(results, cols);
			tResults.setColumnAsLink("email");
			tResults.setColumnId("id");
			model.addAttribute("tResults", tResults);
			return "users/usersList";
		} else {
			// 1 user found
			user = results.iterator().next();
			return "redirect:/users/" + user.getId();
		}
	}

	/**
	 * Custom handler for displaying an owner.
	 *
	 * @param ownerId
	 *            the ID of the owner to display
	 * @return a ModelMap with the model attributes for the view
	 */
	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
	public ModelAndView showUser(@PathVariable("userId") int userId) {
		ModelAndView mav = new ModelAndView("users/userDetails");
		User user = this.applicationService.findUserById(userId);
		mav.addObject(user);

		String[] cols = { "id", "name", "email", "password", "enabled" };
		DataTableConverter tObject = new DataTableConverter(user, cols);
		mav.addObject("tObject", tObject);

		String[] buttons = { "edit", "delete", "enable", "detail" };
		mav.addObject("tButtons", buttons);

		return mav;
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.POST)
	public String editData(@PathVariable("userId") int userId,
			@RequestParam(value = "action", required = true) String action, Model model) {

		String resp = "users/userDetails";
		User user = this.applicationService.findUserById(userId);
		model.addAttribute("user", user);

		String[] cols = { "id", "name", "email", "password", "enabled" };
		DataTableConverter tObject = new DataTableConverter(user, cols);
		model.addAttribute("tObject", tObject);

		String[] buttons = { "edit", "delete", "enable", "detail" };
		model.addAttribute("tButtons", buttons);

		switch (action) {
		case "edit":
			System.out.println(action);
			resp = "users/createOrUpdateUserForm";
			break;
		case "delete":
			System.out.println(action);
			break;
		}
		return resp;
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
	public String updateData(@Valid User user, BindingResult result, SessionStatus status, Model model,
			@RequestParam(value = "action", required = true) String action) {
		String resp = "";

		switch (action) {
		case "update":
			if (result.hasErrors()) {
				String[] cols = { "id", "name", "email", "password", "enabled" };
				DataTableConverter tObject = new DataTableConverter(user, cols);
				model.addAttribute("tObject", tObject);
				resp = "users/createOrUpdateUserForm";
			} else {
				this.applicationService.saveUser(user);
				status.setComplete();
				resp = "redirect:/users/{userId}";
			}
			break;
		case "cancel":
			resp = "redirect:/users/{userId}";
			break;
		}
		return resp;
	}

}
