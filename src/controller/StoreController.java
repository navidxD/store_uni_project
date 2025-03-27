package controller;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import model.cart.CartManager;
import model.product.Product;
import model.product.ProductManager;
import model.user.UserManager;
import view.MenuView;
import view.ProductView;

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
			if (cmd == ViewControllerListener.CMD_INVENTORY_ADD) {
				inventory.createProduct(productView.getProductFromForm());
				productView.updateListProduct(inventory.getAll());
			}
			if (cmd == ViewControllerListener.CMD_INVENTORY_DELETE) {
				inventory.deleteProduct(productView.getProductFromForm());
				productView.updateListProduct(inventory.getAll());
			}
			if (cmd == ViewControllerListener.CMD_INVENTORY_UPDATE) {
				inventory.updateProduct(productView.getProductFromForm());
				productView.updateListProduct(inventory.getAll());
			}
			
			if (cmd == ViewControllerListener.CMD_MENU) {
				dismissAllView();
				showMainMenu();
			}
		}
	};
	
	private ProductManager inventory;
	private UserManager userManager;
	private CartManager cartManager;
	private MenuView menuView;
	private ProductView productView;
	
	public void init() {
		inventory = new ProductManager();
		userManager = new UserManager();
		cartManager = new CartManager();
		
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
		productView.setViewControllerListener(viewControllerListener);
		productView.updateListProduct(inventory.getAll());
		showView(productView);
	}

	private void dismissAllView() {
		dismissView(menuView);
		dismissView(productView);
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
