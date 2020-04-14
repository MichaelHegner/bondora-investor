package net.hemisoft.investor.bondora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BondoraInvestorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BondoraInvestorApplication.class, args);
	}

//	@Bean
//	public RestTemplate restTemplate(OAuth2AuthorizedClientService clientService) {
//		return new RestTemplateBuilder()
//				.interceptors(
//				 (ClientHttpRequestInterceptor) (httpRequest, bytes, execution) -> {
//					 OAuth2AuthenticationToken token = OAuth2AuthenticationToken.class.cast(SecurityContextHolder.getContext().getAuthentication());
//					 OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(token.getAuthorizedClientRegistrationId(), token.getName());
//					 httpRequest.getHeaders().add(HttpHeaders.AUTHORIZATION, "Bearer" + client.getAccessToken().getTokenValue());
//					 return execution.execute(httpRequest, bytes);
//				 }
//				)
//				.build();
//	}
}
