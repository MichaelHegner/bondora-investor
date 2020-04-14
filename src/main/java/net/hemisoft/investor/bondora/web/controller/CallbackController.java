package net.hemisoft.investor.bondora.web.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import net.hemisoft.investor.bondora.web.session.AccessToken;

@Slf4j
@Controller
public class CallbackController {
	
	@Value("${client-id}")     String clientId;
	@Value("${client-secret}") String clientSecret;
	@Value("${spring.security.oauth2.client.provider.bondora.token-uri}")
	String tokenUri;
	
	@Autowired
	OAuth2AuthorizedClientService clientService;
	
	@Autowired
	RestTemplate template;

	@GetMapping("/callback")
	public ModelAndView get(String code, AccessToken accessToken) {
		if (!accessToken.hasAccessToken()) BeanUtils.copyProperties(getNewAccessToken(code), accessToken);
		
		ModelAndView mav = new ModelAndView("callback");
		mav.addObject("code", code);
		mav.addObject("client_id", clientId);
		mav.addObject("client_secret", clientSecret);
		mav.addObject("response", accessToken);
		return mav;
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
