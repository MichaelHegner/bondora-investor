package net.hemisoft.investor.bondora.auth.dto;

import lombok.NonNull;
import lombok.Value;

@Value
public class AuthDto {
	final String responseType = "code";
	
	@NonNull String clientId;
	
	String state       = "xyz";
	String scope       = "BidsRead";
	String redirectUri = "http:localhost:8080/account";
}
