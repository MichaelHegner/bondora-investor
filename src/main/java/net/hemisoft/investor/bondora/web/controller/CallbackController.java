package net.hemisoft.investor.bondora.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
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
	ClientRegistrationRepository repository;
	
	
	@Autowired
	RestTemplate template;

	@GetMapping("/callback")
	public ModelAndView get(String code, OAuth2AuthenticationToken token, @AuthenticationPrincipal OAuth2User principal) {
		MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
		parts.add("grant_type", "authorization_code");
		parts.add("client_id", clientId);
		parts.add("client_secret", clientSecret);
		parts.add("code", code);
		
		String response = template.postForObject(tokenUri, parts, String.class);
		
		ModelAndView mav = new ModelAndView("callback");
		mav.addObject("code", code);
		mav.addObject("client_id", clientId);
		mav.addObject("client_secret", clientSecret);
		mav.addObject("tokenUri", tokenUri);
		mav.addObject("token", token);
		mav.addObject("principal", principal);
		mav.addObject("response", response);
		mav.addObject("registration", repository.findByRegistrationId(code));
		return mav;
	}

}
