package model.product;

import model.base.BasePersistence;

public class ProductPersistence extends BasePersistence<Product> {

	@Override
	public void init() {
	}
	
	public boolean createProduct() {
		return add(new Product());
	}
}
