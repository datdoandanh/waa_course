package edu.mum.waa.lab05.prob1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN").and().withUser("sales")
				.password("sales").roles("SALES").and().withUser("accountant").password("accountant")
				.roles("ACCOUNTANT");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/welcome", "/login").permitAll().and().formLogin().loginPage("/login")
				.usernameParameter("username").passwordParameter("password")
				.defaultSuccessUrl("/welcome").permitAll();
	}

}
