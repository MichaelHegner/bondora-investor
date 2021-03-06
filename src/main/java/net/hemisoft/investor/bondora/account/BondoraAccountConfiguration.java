//package net.hemisoft.investor.bondora.account;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.integration.dsl.IntegrationFlow;
//import org.springframework.integration.dsl.IntegrationFlows;
//import org.springframework.integration.http.dsl.Http;
//
//import lombok.NoArgsConstructor;
//import net.hemisoft.investor.bondora.web.session.AccessTokenService;
//
//@Configuration
//@NoArgsConstructor
//public class BondoraAccountConfiguration {
//	
//	@Value("${app.bondora.url.account.balance}") String balanceUrl;
//	
//	@Autowired AccessTokenService accessTokenService;
//	
//	@Bean
//	public IntegrationFlow requestAccountFlow() {
//		 return IntegrationFlows.from(Http.inboundGateway("/account")
//		            .requestMapping(m -> m.methods(HttpMethod.GET))
//		            .requestPayloadType(String.class))
//		        .channel("httpAccountRequest")
//		        .get();
//	}
//	
//	@Bean
//	public IntegrationFlow bondoraAccountFlow() {
//		return IntegrationFlows.from("httpAccountRequest")
//				.enrichHeaders(h -> h.header(HttpHeaders.AUTHORIZATION, "Bearer" + accessTokenService.getAccessToken().getAccess_token()))
//				.handle(
//						Http.outboundGateway(balanceUrl)
//						.httpMethod(HttpMethod.GET)
//						.expectedResponseType(String.class)					
//						)
//				.logAndReply();
//	}
//	
//}
