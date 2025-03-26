package controller;

import model.cart.CartManager;
import model.product.Inventory;
import model.user.UserManager;

public class StoreController {
	
	private Inventory inventory;
	private UserManager userManager;
	private CartManager cartManager;
	
	public void init() {
		inventory = new Inventory();
		userManager = new UserManager();
		cartManager = new CartManager();
	}

}
