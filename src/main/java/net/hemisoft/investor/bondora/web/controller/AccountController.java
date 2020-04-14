package net.hemisoft.investor.bondora.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AccountController {
	@Value("${app.bondora.url.account.balance}") 
	String balanceUrl;
	
	@Autowired 
	RestTemplate template;

	@GetMapping("/account")
	public ModelAndView get() {
		log.info("getAccount on " + balanceUrl);
		template.getInterceptors().forEach(i -> log.info(i.toString()));
		
		ModelAndView mav = new ModelAndView("account");
		mav.addObject("result", template.getForObject(balanceUrl, String.class));
		return mav;
	}
	
}
