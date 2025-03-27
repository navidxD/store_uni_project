package model.cart;

import java.util.ArrayList;

import model.base.BasePersistence;
import model.product.Product;
import model.user.User;

public class CartManager extends BasePersistence<Cart>{
	
	private User user;
	private ArrayList<Product> products;

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
	public void startSale() {
		user = new User();
		
		user.setEmail("N/A");
		user.setIdUser("DESCONOCIDO");
		user.setLastName("N/A");
		user.setName("N/A");
		
		products = new ArrayList<Product>();
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public void addProductToSale(Product p) {
		products.add(p);
	}
	
	public void removeProductToSale(Product p) {
		for (int i = 0 ; i < products.size(); i++) {
			if (products.get(i).getId().equals(p.getId())) {
				products.remove(i);
				break;
			}
		}
	}
	
	public void completeSale() {
		Cart cartToSave = new Cart();
		
		cartToSave.setProducts(products);
		cartToSave.setUser(user);
		
		add(cartToSave);
	}

}
