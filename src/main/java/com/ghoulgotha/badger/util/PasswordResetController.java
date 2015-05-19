package com.ghoulgotha.badger.util;

import com.ghoulgotha.badger.user.User;
import com.ghoulgotha.badger.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Badger on 5/14/15.
 */
@RequestMapping(value = "/reset/password")
@Controller
public class PasswordResetController {

	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;

	@RequestMapping(method = RequestMethod.GET)
	public String resetPassword(Model model) {
		model.addAttribute("auth", false);
		return "password";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String resetPasswordAction(String username, RedirectAttributes attr) {
		User user = userService.findByUsername(username);
		if (user == null || user.getId() == null) {
			attr.addFlashAttribute("alertError", "Badger " + username + " does not exist");
			return "redirect:/reset/password";
		}
		String pass = newPasswordHash();
		user.setPassword(new BCryptPasswordEncoder().encode(pass));
		userService.save(user);
		/*Map<String, Object> data = new HashMap<>();
		data.put("user", user);*/
		Map<String, Object> data = new HashMap<String, Object>() {{
			put("user", user);
			put("pass", pass);
		}};
		emailService.send("Password reset <reset@socialbadger.com>", username, "Reset password request", "", "email/password.ftl", data);
		attr.addFlashAttribute("alert", "Email sent with temporary password to " + username + ", a stupid badger");
		return "redirect:/";
	}

	private String newPasswordHash() {
		return UUID.randomUUID().toString().replace("-", "").substring(0, 9);
	}
}
