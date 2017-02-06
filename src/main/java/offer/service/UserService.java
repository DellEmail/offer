//
// 
//
package offer.service;

import java.util.Collection;

import offer.bean.UserBean;
import offer.model.User;

public interface UserService {
	
	User getUserById(long id);

    User getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserBean userBean);
}
