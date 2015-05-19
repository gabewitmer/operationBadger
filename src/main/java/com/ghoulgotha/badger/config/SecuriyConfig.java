package com.ghoulgotha.badger.config;

import com.ghoulgotha.badger.CustomAuthHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;


@Configuration
@EnableWebMvcSecurity
public class SecuriyConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	DataSource dataSource;

	@Autowired
	private void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		auth
				.jdbcAuthentication()
				.dataSource(dataSource)
				.passwordEncoder(encoder)
				.usersByUsernameQuery("select username, password, active from user where username=?")
				.authoritiesByUsernameQuery("select username, role from user where username=?");
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/admin/**").hasAnyRole("ADMIN")
				.antMatchers("/secure/**").hasAnyRole("ADMIN", "USER");
		http.formLogin()
				.loginPage("/").defaultSuccessUrl("/secure")
				.successHandler(new CustomAuthHandler());
		http.logout()
				.invalidateHttpSession(true)
				.logoutSuccessUrl("/")
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"));
		http.sessionManagement()
				.maximumSessions(2)
				.expiredUrl("/login?expired")
				.maxSessionsPreventsLogin(false)
				.and().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
	}
}
