package net.hemisoft.investor.bondora.web.session;

import org.springframework.util.StringUtils;

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
	
	public boolean hasAccessToken() {
		return StringUtils.hasLength(access_token);
	}
}
