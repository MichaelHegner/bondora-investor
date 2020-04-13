package net.hemisoft.investor.bondora.web.controller;

import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CallbackController {

	@GetMapping("/callback")
	public ModelAndView get(String code, OAuth2AuthenticatedPrincipal token) {
		ModelAndView mav = new ModelAndView("callback");
		mav.addObject("code", code);
		mav.addObject("principal", token);
		return mav;
	}
	
}
