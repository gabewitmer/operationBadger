package com.ghoulgotha.badger.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/secure/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserSession userSession;

	@RequestMapping(method = RequestMethod.GET)
	public String uAccount(Model model) {
		User user = userService.findOne(userSession.getId());
		model.addAttribute("user", user);
		model.addAttribute("auth", (userSession.getId() != null));
		// model.addAttribute("user", userService.findByUsername(principal.getName()))
		return "user/user";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String updateUser(User user, RedirectAttributes attr) {
		if (userService.canUpdate(user.getId(), user.getUsername(), user.getDisplayName())) {
			if ("".equals(user.getPassword()) || user.getPassword() == null) {
				User existingUser = userService.findOne(user.getId());
				user.setPassword(existingUser.getPassword());
			} else {
				user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			}
			userService.save(user);
			attr.addFlashAttribute("alertSuccess", "Badger is ballin' and up to date");
		} else {
			attr.addFlashAttribute("alertError", "Unable to change Badger to Badger, " + user.getUsername() + " may already be Badgered.");
		}
		return "redirect:/secure/user";
	}

	@RequestMapping(value = "/del/{id}",method = RequestMethod.POST)
	public String deleteUser(@PathVariable Long id, RedirectAttributes attr) {
		userService.delete(id);
		attr.addFlashAttribute("alertSuccess", "Badger has died");
		return "redirect:/logout";
	}
}
