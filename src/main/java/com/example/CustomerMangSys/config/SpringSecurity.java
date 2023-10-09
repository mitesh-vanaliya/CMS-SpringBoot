package com.example.CustomerMangSys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

	//configure security filter chain bean
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity)
	{
		try {
			httpSecurity
			.authorizeHttpRequests(authorize -> authorize
					.requestMatchers("/blog/**").permitAll()
					.anyRequest()
					.authenticated())
			
			.formLogin(formLogin -> formLogin
					.loginPage("/login")
					.loginProcessingUrl("/login")
					.defaultSuccessUrl("/index")
					.permitAll()
					)
			.logout(logout -> logout
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.permitAll())
			.rememberMe(Customizer.withDefaults());
			return httpSecurity.build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
}
