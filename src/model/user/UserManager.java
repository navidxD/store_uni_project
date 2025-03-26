package model.user;

import model.base.BasePersistence;

public class UserManager extends BasePersistence<User> {
	
	private static int BASE_ID = 1;

	@Override
	public void init() {
	}
	
	public boolean createProduct(String idUser, String name, String lastName, String email) {
		User user = new User();
		
		user.setIdUser(idUser);
		user.setName(name);
		user.setLastName(lastName);
		user.setEmail(email);
		
		return add(user);
	}

	public boolean updateUser(User user) {
		if (user != null) {
			updateById(user);
			return true;
		}
		return false;
	}
	
	private int getIdUser() {
		return BASE_ID++;
	}

}
