package net.hemisoft.investor.bondora.web.session;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AccessToken {
	String access_token;
	String scope;
	String token_type;
	String expires_in;
	String refresh_token;
}
