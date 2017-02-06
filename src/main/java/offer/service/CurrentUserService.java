//
// 
//
package offer.service;

import offer.bean.CurrentUser;

public interface CurrentUserService {
	
	 boolean canAccessUser(CurrentUser currentUser, Long userId);
}
