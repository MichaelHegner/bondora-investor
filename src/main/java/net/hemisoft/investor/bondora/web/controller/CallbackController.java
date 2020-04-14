package net.hemisoft.investor.bondora.web.controller;

import static org.thymeleaf.util.StringUtils.substring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CallbackController {
	
	@Value("${client-id}")     String clientId;
	@Value("${client-secret}") String clientSecret;
	@Value("${spring.security.oauth2.client.provider.bondora-authz.token-uri}")
	String tokenUri;
	
	
	@Autowired
	RestTemplate template;

	@GetMapping("/callback")
	public ModelAndView get(String code, OAuth2AuthenticationToken token) {
		MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
		parts.add("grant_type", "authorization_code");
		parts.add("client_id", clientId);
		parts.add("client_secret", clientSecret);
		parts.add("code", code);
		parts.add("redirect_uri", "/callback");
		
		
		String response = template.postForObject(tokenUri, parts, String.class);
		
		ModelAndView mav = new ModelAndView("callback");
		mav.addObject("code", code);
		mav.addObject("client_id", substring(clientId, 0, 5));
		mav.addObject("client_secret", substring(clientSecret, 0, 5));
		mav.addObject("tokenUri", substring(tokenUri, 0, 5));
		mav.addObject("token", token);
		mav.addObject("response", response);
		return mav;
	}
	
}
