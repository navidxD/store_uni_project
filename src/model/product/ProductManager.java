package model.product;

import model.base.BasePersistence;

public class ProductManager extends BasePersistence<Product> {
	
	private static int BASE_ID = 1;

	@Override
	public void init() {
	}
	
	public boolean createProduct(Product p) {		
		return add(p);
	}

	public boolean updateProduct(Product product) {
		if (product != null) {
			updateById(product);
			return true;
		}
		return false;
	}
	
	public boolean deleteProduct(Product product) {
		if (product != null) {
			deleteById(product.getId());
			return true;
		}
		return false;
	}
	
	private int getIdProduct() {
		return BASE_ID++;
	}
}
