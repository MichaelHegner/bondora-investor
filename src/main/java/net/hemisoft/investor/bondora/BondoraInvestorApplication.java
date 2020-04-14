package net.hemisoft.investor.bondora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import net.hemisoft.investor.bondora.web.session.AccessTokenService;


@SpringBootApplication
public class BondoraInvestorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BondoraInvestorApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(AccessTokenService accessTokenService) {
		return new RestTemplateBuilder()
				.interceptors(
				 (ClientHttpRequestInterceptor) (httpRequest, bytes, execution) -> {
					 httpRequest.getHeaders().add(HttpHeaders.AUTHORIZATION, "Bearer" + accessTokenService.getAccessToken().getAccess_token());
					 return execution.execute(httpRequest, bytes);
				 }
				)
				.build();
	}
	
}
