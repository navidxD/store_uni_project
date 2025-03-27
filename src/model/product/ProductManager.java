package model.product;

import model.base.BasePersistence;

public class ProductManager extends BasePersistence<Product> {
	
	private static int BASE_ID = 1;

	@Override
	public void init() {
	}
	
	public boolean createProduct(Product p) {
		Product product = new Product();
		
		product.setProductId(getIdProduct());
		product.setPrice(p.getPrice());
		product.setName(p.getName());
		
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
