package model.product;

import model.base.BaseModel;

/**
 * Clase que representa un producto en el sistema.
 * Extiende de BaseModel para heredar funcionalidades básicas.
 */
public class Product extends BaseModel {
	
    /** Identificador único del producto */
    private int productId;
    /** Nombre del producto */
    private String name;
    /** Descripción del producto */
    private String descrption;
    /** Precio del producto */
    private double price;
    /** Cantidad del producto */
    private int quantity;

    /**
     * Obtiene el ID del producto
     * @return el ID del producto
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Establece el ID del producto
     * @param productId el nuevo ID a establecer
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * Obtiene el precio del producto
     * @return el precio del producto
     */
    public double getPrice() {
        return price;
    }

    /**
     * Establece el precio del producto
     * @param price el nuevo precio a establecer
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Obtiene el nombre del producto
     * @return el nombre del producto
     */
    public String getName() {
		return name;
	}

    /**
     * Establece el nombre del producto
     * @param name el nuevo nombre a establecer
     */
    public void setName(String name) {
		this.name = name;
	}
    
    /**
     * Obtiene la descripción del producto
     * @return la descripción del producto
     */
	public String getDescrption() {
		return descrption;
	}

    /**
     * Establece la descripción del producto
     * @param descrption la nueva descripción a establecer
     */
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}

    public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
     * Devuelve una representación en cadena del objeto Product
     * @return cadena con los datos del producto
     */
	@Override
	public String toString() {
		return "[productId=" + productId + ", name=" + name + ", price=" + price + "]";
	}
}
