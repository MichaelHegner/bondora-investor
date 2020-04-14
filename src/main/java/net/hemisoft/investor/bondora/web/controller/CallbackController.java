package net.hemisoft.investor.bondora.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import lombok.extern.slf4j.Slf4j;
import net.hemisoft.investor.bondora.web.session.AccessToken;
import net.hemisoft.investor.bondora.web.session.AccessTokenService;

@Slf4j
@Controller
public class CallbackController {
	
	@Value("${client-id}")     String clientId;
	@Value("${client-secret}") String clientSecret;
	@Value("${spring.security.oauth2.client.provider.bondora.token-uri}")
	String tokenUri;
	
	@Autowired
	AccessTokenService accessTokenService;
	
	@Autowired
	RestTemplate template;

	@GetMapping("/callback")
	public ModelAndView get(String code) {
		accessTokenService.setAccessToken(getNewAccessToken(code));
		return new ModelAndView(new RedirectView("/account"));
	}
	
	
	private AccessToken getNewAccessToken(String code) {
		log.info("Get new access token by code: " + code);
		MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
		parts.add("grant_type", "authorization_code");
		parts.add("client_id", clientId);
		parts.add("client_secret", clientSecret);
		parts.add("code", code);
		return template.postForObject(tokenUri, parts, AccessToken.class);
	}
	

}
