package net.hemisoft.investor.bondora.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CallbackController {

	@GetMapping("/callback")
	public ModelAndView get(@RequestParam String code) {
		ModelAndView mav = new ModelAndView("callback");
		mav.addObject("code", code);
		return mav;
	}
	
}
