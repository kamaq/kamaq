package com.raw.kamaq.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.raw.kamaq.model.Module;
import com.raw.kamaq.service.UserService;

@Controller
@SessionAttributes(types = Module.class)
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/users/new", method = RequestMethod.POST)
	public String processCreationUser(SessionStatus status) {
		Module module = new Module();
		module.setName("734800 sp dy");
		module.setDescription("descrip");
		module.setImageFileName("image.png");
		this.userService.saveModule(module);
		status.setComplete();

		System.out.println("usuario: " + (this.userService.findUserById(1)).getName());
		return "/main/welcome";
	}
}
