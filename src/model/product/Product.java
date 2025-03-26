package model.product;

import model.base.BaseModel;

public class Product extends BaseModel {
	
    private int productId;
    private String name;
    private double price;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}
    
    
    
}
