package model.cart;

import java.util.ArrayList;

import model.base.BaseModel;
import model.product.Product;
import model.user.User;

public class Cart extends BaseModel {
	
	private User user;
	private ArrayList<Product> products;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ArrayList<Product> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	public double calculateTotal() {
		double total = 0;
		
		for (Product p : products) {
			total = total + p.getPrice();
		}
		
		return total;
	}
	
}
