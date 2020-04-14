package net.hemisoft.investor.bondora.auth.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AuthResponseDto {
	String access_token;
	String scope;
	String token_type;
	String expires_in;
	String refresh_token;
}
