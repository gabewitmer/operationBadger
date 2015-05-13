package com.ghoulgotha.badger;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CustomAuthHandler implements AuthenticationSuccessHandler {

	RedirectStrategy redirect = new DefaultRedirectStrategy();

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		String successUrl = "/login/success";
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) authentication.getAuthorities();
		for (int i = 0; i < authorities.size(); i++) {
			GrantedAuthority authority = authorities.get(i);
			switch (authority.getAuthority()) {
				case "ROLE_USER":
					successUrl += "?role=user";
					break;
				case "ROLE_ADMIN":
					successUrl += "?role=admin";
					break;
			}
		}

		if(response.isCommitted()){
			return;
		}
		redirect.sendRedirect(request, response, successUrl);
	}
}
