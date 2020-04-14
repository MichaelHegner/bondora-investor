package net.hemisoft.investor.bondora.web.controller;

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
	
	
	@Autowired
	RestTemplate template;

	@GetMapping("/callback")
	public ModelAndView get(String code, OAuth2AuthenticationToken token) {
		MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
		parts.add("grant_type", "authorization_code");
		parts.add("client_id", clientId);
		parts.add("client_secret", clientSecret);
		parts.add("code", code);
//		parts.add("redirect_uri", "/callback");
		String response = template.postForObject("https://api.bondora.com/oauth/access_token", parts, String.class);
		
		ModelAndView mav = new ModelAndView("callback");
		mav.addObject("code", code);
		mav.addObject("client-id", org.thymeleaf.util.StringUtils.substring(clientId, 0, 5));
		mav.addObject("client-secret", org.thymeleaf.util.StringUtils.substring(clientSecret, 0, 5));
		mav.addObject("response", response);
		mav.addObject("token", token);
		return mav;
	}
	
}
