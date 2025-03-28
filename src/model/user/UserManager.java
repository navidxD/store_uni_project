package model.user;

import model.base.BasePersistence;
import model.product.Product;

public class UserManager extends BasePersistence<User> {
	
	private static int BASE_ID = 1;

	@Override
	public void init() {
	}
	
	public boolean createUser(User user) {		
		return add(user);
	}

	public boolean updateUser(User user) {
		if (user != null) {
			updateById(user);
			return true;
		}
		return false;
	}
	
	public boolean deleteUser(User user) {
		if (user != null) {
			deleteById(user.getId());
			return true;
		}
		return false;
	}
	
	private int getIdUser() {
		return BASE_ID++;
	}

}
