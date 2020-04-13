package net.hemisoft.investor.bondora.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CallbackController {

	@GetMapping("/callback")
	public ModelAndView get(@RequestParam String code, @AuthenticationPrincipal OAuth2User principal) {
		ModelAndView mav = new ModelAndView("callback");
		mav.addObject("code", code);
		mav.addObject("principal", principal);
		return mav;
	}
	
}
