package net.hemisoft.investor.bondora.auth.dto;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class BondoraAuthenticationConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/login**", "/error**", "/callback**", "/user**").permitAll()
		        .anyRequest().authenticated()
		        .and().logout().logoutUrl("/logout").logoutSuccessUrl("/")
		        .and().oauth2Login()
		        .defaultSuccessUrl("/account")
		        .failureUrl("/error");
	}

//	@Bean
//	public ClientRegistrationRepository clientRegistrationRepository(
//			@Value("${client-id}") String clientId, // Configured in system properties (Eclipse)
//			@Value("${client-secret}") String clientSecret // Configured in system properties (Eclipse)
//	) {
//		List<ClientRegistration> registrations = new ArrayList<>();
//		registrations.add(bondoraClientRegistration(clientId, clientSecret));
//		return new InMemoryClientRegistrationRepository(registrations);
//	}
//
//	private ClientRegistration bondoraClientRegistration(String clientId, String clientSecret) {
//		return ClientRegistration.withRegistrationId("bondora")
//				.clientId(clientId)
//				.clientSecret(clientSecret)
//				.authorizationUri("https://www.bondora.com/oauth/authorize")
//				.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//				.tokenUri("https://api.bondora.com/oauth/access_token")
//				.redirectUriTemplate("https://bondora-investor.herokuapp.com/callback") // After success Login
////				.userInfoUri("https://api.bondora.com/user")
//				.clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
//				.scope("BidsRead")
//				.clientName("Bondora")
//				.build();
//	}

}
