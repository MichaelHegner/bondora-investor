package net.hemisoft.investor.bondora.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class BondoraAuthenticationConfiguration extends WebSecurityConfigurerAdapter {
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/", "/login**", "/login/**", "/error**", "/callback**", "/user**").permitAll()
//		        .anyRequest().authenticated()
//		        .and().logout().logoutUrl("/logout").logoutSuccessUrl("/")
//		        .and().oauth2Login()
//		;
//	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.authorizeRequests( 
//					a -> a.antMatchers("/", "/error**", "/webjars/**", "/favicon.ico")
//						.permitAll()
//						.anyRequest()
//						.authenticated()
//		        )
//			.exceptionHandling(
//					e -> e.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//					)
//			.oauth2Login()
//		;
//	}

}
