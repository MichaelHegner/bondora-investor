package net.hemisoft.investor.bondora.auth.dto;

import lombok.ToString;
import lombok.Value;

@Value
@ToString
public class AuthResponseDto {
	String access_token;
	String scope;
	String token_type;
	String expires_in;
	String refresh_token;
}
