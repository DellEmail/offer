//
// 
//
package offer.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import offer.bean.UserBean;
import offer.model.User;
import offer.model.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User getUserById(long id) {
		LOGGER.debug("Getting user={}", id);
		return userRepository.findOne(id);
	}

	@Override
	public User getUserByEmail(String email) {
		LOGGER.debug("Getting user by email={}", email.replaceFirst("@.*", "@***"));
		return userRepository.findOneByEmail(email);
	}

	@Override
	public Collection<User> getAllUsers() {
		LOGGER.debug("Getting all users");
		return (Collection<User>) userRepository.findAll();
	}

	@Override
	public User create(UserBean userBean) {
		User user = new User();
		user.setUsername(userBean.getUsername());
        user.setEmail(userBean.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(userBean.getPassword()));
        user.setRole(userBean.getRole());
        return userRepository.save(user);
	}

}
