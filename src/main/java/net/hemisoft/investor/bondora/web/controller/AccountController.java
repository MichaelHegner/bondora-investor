package net.hemisoft.investor.bondora.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AccountController {
	@Value("${app.bondora.url.account.balance}") 
	String balanceUrl;
	
	@Autowired 
	RestTemplate template;

	@GetMapping("/account")
	public String get() {
		return template.getForObject(balanceUrl, String.class);
	}
	
}
