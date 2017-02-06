//
// Implementeerib kasutaja teenuse
//
package offer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import offer.bean.CurrentUser;
import offer.model.User;

@Service
public class CurrentUserDetailsService implements UserDetailsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserDetailsService.class);
	
	@Autowired
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		LOGGER.debug("Authenticating user with email={}", email.replaceFirst("@.*", "@***"));
		User user = userService.getUserByEmail(email);
		return new CurrentUser(user);
	}

}
