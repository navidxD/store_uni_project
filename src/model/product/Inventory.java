package model.product;

import model.base.BasePersistence;

public class Inventory extends BasePersistence<Product> {
	
	private static int BASE_ID = 1;

	@Override
	public void init() {
	}
	
	public boolean createProduct(String name, double price) {
		Product product = new Product();
		
		product.setProductId(getIdProduct());
		product.setPrice(price);
		product.setName(name);
		
		return add(product);
	}

	public boolean updateProduct(Product product) {
		if (product != null) {
			updateById(product);
			return true;
		}
		return false;
	}
	
	private int getIdProduct() {
		return BASE_ID++;
	}
}
