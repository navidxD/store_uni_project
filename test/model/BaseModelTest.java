package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.product.Product;
import model.product.ProductManager;

class BaseModelTest {

	@Test
	void test() {
		System.out.println("init test");
		
		ProductManager productManager = new ProductManager();
		productManager.init();
		
		Product p1 = new Product();
		productManager.createProduct(p1);
		productManager.createProduct(p1);
		productManager.createProduct(p1);
		productManager.createProduct(p1);
		
		ArrayList<Product> products = productManager.getProductsSortedByPrice(true);
		
		for (Product p : products) {
			System.out.println(p);
		}
		
	}

}
