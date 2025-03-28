package model.cart;

import java.util.ArrayList;

import model.base.BaseModel;
import model.product.Product;
import model.user.User;

/**
 * Clase que representa un carrito de compras.
 * Extiende de BaseModel para heredar funcionalidades básicas.
 */
public class Cart extends BaseModel {
	
	/** Usuario asociado al carrito */
	private User user;
	/** Lista de productos en el carrito */
	private ArrayList<Product> products;
	/** Precio total del carrito */
	private double totalPrice;  
	
	/**
	 * Obtiene el usuario del carrito
	 * @return el usuario asociado al carrito
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Establece el usuario del carrito
	 * @param user el usuario a asociar al carrito
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Obtiene la lista de productos del carrito
	 * @return lista de productos en el carrito
	 */
	public ArrayList<Product> getProducts() {
		return products;
	}

	/**
	 * Establece la lista de productos del carrito y actualiza el precio total
	 * @param products lista de productos a establecer
	 */
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
		getTotalPrice();
	}

	/**
	 * Obtiene el precio total del carrito
	 * @return el precio total actual
	 */
	public double getTotalPrice() {
		this.totalPrice = 0;
		
		for (Product p : products) {
			totalPrice += p.getPrice() * p.getQuantity();
		}
		
		return totalPrice;
	}

	/**
	 * Actualiza el precio total del carrito basado en los productos actuales
	 */
	public void updateTotalPrice() {
		this.totalPrice = products != null ?
			products.stream()
				.mapToDouble(Product::getPrice)
				.sum() : 0.0;
	}
}
