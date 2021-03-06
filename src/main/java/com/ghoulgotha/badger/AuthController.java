package com.ghoulgotha.badger;

import com.ghoulgotha.badger.user.User;
import com.ghoulgotha.badger.user.UserService;
import com.ghoulgotha.badger.user.UserSession;
import com.ghoulgotha.badger.util.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AuthController {

	@Autowired
	private EmailService emailService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserSession userSession;

	@RequestMapping(value = "/login/success", method = RequestMethod.GET)
	public String customeLoginSuccessHandler(@RequestParam("role") String role, Principal principal) {
		if ("admin".equals(role)) {
			return "redirect:/admin";
		} else {
			User user = userService.findByUsername(principal.getName());
			userSession.setId(user.getId());
			return "redirect:/secure/user";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("auth", (userSession.getId() != null));
		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(User user, RedirectAttributes attr) {
		if (userService.canUpdate(user.getId(), user.getUsername(), user.getDisplayName())) {
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			userService.save(user);
			attr.addFlashAttribute("alertSuccess", "Successfully registered. Please login");
			Map<String, Object> data = new HashMap<>();
			data.put("user", user);
			emailService.send("Badger registration <registration@socialbadger.com>", user.getUsername(), "Get Badgered", "", "email/registration.ftl", data);
		} else {
			attr.addFlashAttribute("alertError", "Unable to Badger Badger, " + user.getUsername() + " may already be Badgered.");
		}
		return "redirect:/login";
	}
}
