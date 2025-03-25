package main;

import java.util.ArrayList;
import java.util.List;

import model.product.Product;
import model.product.ProductPersistence;

public class Main {
	
	public static void main(String[] args) {
		
		ProductPersistence persistence = new ProductPersistence();
		persistence.init();
		persistence.createProduct();
		
	}
	
}
