package controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

import model.cart.CartManager;
import model.product.Product;
import model.product.ProductManager;
import model.user.UserManager;
import view.CartView;
import view.DialogUtil;
import view.MenuView;
import view.ProductView;
import view.UserView;

public class StoreController {
	
	private ViewControllerListener viewControllerListener = new ViewControllerListener() {
		@Override
		public void onReceiveComand(ActionEvent e, int cmd) {
			// TODO Auto-generated method stub
			System.out.println("StoreController onReceiveComand" + cmd);	
			
			if (cmd == ViewControllerListener.CMD_INVENTORY) {
				dismissAllView();
				showProductMenu();
			}
			else if (cmd == ViewControllerListener.CMD_INVENTORY_ADD) {
				productManager.createProduct(productView.getProductFromForm());
				productView.updateListProduct(productManager.getAll());
			}
			else if (cmd == ViewControllerListener.CMD_INVENTORY_DELETE) {
				productManager.deleteProduct(productView.getProductFromForm());
				productView.updateListProduct(productManager.getAll());
			}
			else if (cmd == ViewControllerListener.CMD_INVENTORY_UPDATE) {
				productManager.updateProduct(productView.getProductFromForm());
				productView.updateListProduct(productManager.getAll());
			}
			else if (cmd == ViewControllerListener.CMD_USER) {
				dismissAllView();
				showUserMenu();
			}
			else if (cmd == ViewControllerListener.CMD_USER_ADD) {
				userManager.createUser(userView.getUserFromForm());
				userView.updateListUser(userManager.getAll());
			}
			else if (cmd == ViewControllerListener.CMD_USER_UPDATE) {
				userManager.updateUser(userView.getUserFromForm());
				userView.updateListUser(userManager.getAll());
			}
			else if (cmd == ViewControllerListener.CMD_USER_DELETE) {
				userManager.deleteUser(userView.getUserFromForm());
				productView.updateListProduct(productManager.getAll());
			}
			else if (cmd == ViewControllerListener.CMD_CART) {
				if (productManager.getAll().isEmpty()) {
					dialogUtil.showMessage("No existen productos");
				} else {
					dismissAllView();
					showCartMenu();
				}
			}
			else if (cmd == ViewControllerListener.CMD_CART_SELECTED_USER) {
				cartManager.setUser(cartView.getSelectedUser());
			}
			else if (cmd == ViewControllerListener.CMD_CART_SELECTED_PRODUCT) {
				cartManager.updateProduct(cartView.getSelectedProduct());
				cartView.updateResult(cartManager.getCart().getTotalPrice(), cartManager.getCart().getProducts());
			}
			else if (cmd == ViewControllerListener.CMD_CART_CLEAN) {
				cartManager.clearCart();
				cartView.updateResult(cartManager.getCart().getTotalPrice(), cartManager.getCart().getProducts());
			}
			else if (cmd == ViewControllerListener.CMD_CART_COMPLETE) {
				if (cartManager.getCart().getProducts().isEmpty()) {
					dialogUtil.showMessage("Carrito Vacio");
				} else {
					cartManager.completeSale();
					cartView.showComplete(
							cartManager.getCart().getId(),
							cartManager.getCart().getUser(),
							cartManager.getCart().getTotalPrice());	
				}
			}
			else if (cmd == ViewControllerListener.CMD_MENU) {
				dismissAllView();
				showMainMenu();
				cartManager.clearCart();
			}
		}
	};
	
	private ProductManager productManager;
	private UserManager userManager;
	private CartManager cartManager;
	private MenuView menuView;
	private ProductView productView;
	private UserView userView;
	private CartView cartView;
	private DialogUtil dialogUtil;
	
	public void init() {
		productManager = new ProductManager();
		userManager = new UserManager();
		cartManager = new CartManager();
		dialogUtil = new DialogUtil();
		
		showMainMenu();
	}
	
	private void showMainMenu() {
		if (menuView == null) {
			menuView = new MenuView();
		}
		menuView.setViewControllerListener(viewControllerListener);
		showView(menuView);
	}
	
	private void showProductMenu() {
		if (productView == null) {
			productView = new ProductView();
		}
		productView.clean();
		productView.setViewControllerListener(viewControllerListener);
		productView.updateListProduct(productManager.getAll());
		showView(productView);
	}
	
	private void showUserMenu() {
		if (userView == null) {
			userView = new UserView();
		}
		userView.setViewControllerListener(viewControllerListener);
		userView.updateListUser(userManager.getAll());
		showView(userView);
	}
	
	private void showCartMenu() {
		if (cartView == null) {
			cartView = new CartView();
		}
		
		cartManager.startSale();
		cartView.setViewControllerListener(viewControllerListener);
		cartView.updateListProduct(productManager.getAll());
		cartView.updateListUser(userManager.getAll());
		cartView.updateResult(0.0, new ArrayList<Product>());
		
		showView(cartView);
	}

	private void dismissAllView() {
		dismissView(menuView);
		dismissView(productView);
		dismissView(userView);
		dismissView(cartView);
	}
	
	private void showView(JFrame view) {
		changeVisibityView(view, true);
	}
	
	private void dismissView(JFrame view) {
		changeVisibityView(view, false);
	}
	
	private void changeVisibityView(JFrame view, boolean b) {
		if (view != null) {
			view.setVisible(b);	
		}
	}

}
