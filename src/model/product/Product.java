package model.product;

import model.base.BaseModel;

public class Product extends BaseModel {
	
    private int productId;
    private String name;
    private String descrption;
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

    public String getName() {
		return name;
	}

    public void setName(String name) {
		this.name = name;
	}
    
    
	public String getDescrption() {
		return descrption;
	}

	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}

	@Override
	public String toString() {
		return "[productId=" + productId + ", name=" + name + ", price=" + price + "]";
	}
    
    
    
}
