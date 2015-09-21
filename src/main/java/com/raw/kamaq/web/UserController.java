package com.raw.kamaq.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.raw.kamaq.model.User;
import com.raw.kamaq.service.UserService;

@Controller
@SessionAttributes(types = User.class)
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/users/new", method = RequestMethod.POST)
	public String processCreationUser() {
		User user = new User();
		user.setName("734800 sp dy");
		this.userService.saveUser(user);
		return "/login/login";
	}
}
