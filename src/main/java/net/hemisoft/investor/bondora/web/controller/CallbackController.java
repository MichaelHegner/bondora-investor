package net.hemisoft.investor.bondora.web.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CallbackController {

	@GetMapping("/callback")
	public ModelAndView get(@RequestParam String code, OAuth2AuthenticationToken token) {
		ModelAndView mav = new ModelAndView("callback");
		mav.addObject("code", code);
		mav.addObject("principal", token);
		return mav;
	}
	
}
