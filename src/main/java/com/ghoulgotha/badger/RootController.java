package com.ghoulgotha.badger;

import com.ghoulgotha.badger.user.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RootController {

	@Autowired
	UserSession userSession;

	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("auth", (userSession.getId() != null));
		return "home";
	}
}
