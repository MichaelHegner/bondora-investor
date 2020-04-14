package net.hemisoft.investor.bondora.web.session;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Getter;
import lombok.Setter;

@Service
@SessionScope
public class AccessTokenService {
	@Getter @Setter
	AccessToken accessToken;
	
	public boolean hasAccessToken() {
		return null != accessToken && accessToken.hasAccessToken();
	}
}
