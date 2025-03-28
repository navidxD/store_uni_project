package model.cart;

import model.base.BasePersistence;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.product.Product;
import model.user.User;

/**
 * Clase que gestiona el carrito de compras.
 * Extiende de BasePersistence para manejar la persistencia de datos.
 */
public class CartManager extends BasePersistence<Cart> {
    /** Carrito actual */
    private Cart cart;
    /** Mapa que almacena la cantidad de cada producto en el carrito */
    private Map<Product, Integer> productQuantities;

    /**
     * Método de inicialización
     */
    @Override
    public void init() {
        // TODO Auto-generated method stub
    }

    /**
     * Inicia una nueva venta creando un carrito vacío
     */
    public void startSale() {
        ArrayList<Product> products = new ArrayList<Product>();

        this.cart.setUser(getUserDefault());
        this.cart.setProducts(products);
    }
    
    /**
     * Finaliza la venta guardando el carrito
     */
    public void completeSale() {
    	add(cart);
    }

    /**
     * Agrega productos al carrito
     * @param product el producto a agregar
     * @param quantity la cantidad de productos a agregar
     */
    public void addProduct(Product product) {
    	/**
        for (int i = 0; i < quantity; i++) {
            this.cart.getProducts().add(product);
        }
        productQuantities.merge(product, quantity, Integer::sum);
        **/
        
        this.cart.getProducts().add(product);
    }

    /**
     * Actualiza productos del carrito
     * @param product el producto a eliminar
     * @param quantity la cantidad de productos a eliminar
     */
    public void updateProduct(Product product) {
    	/**
        int currentQuantity = productQuantities.getOrDefault(product, 0);

        for (int i = 0; i < quantity; i++) {
            this.cart.getProducts().remove(product);
        }

        if (currentQuantity == quantity) {
            productQuantities.remove(product);
        } else {
            productQuantities.put(product, currentQuantity - quantity);
        }
        **/
    	
    	int index = -1;
    	
    	for (int i = 0; i < cart.getProducts().size(); i++) {
    		Product p = cart.getProducts().get(i);
    		if(p.getProductId() == product.getProductId()) {
    			index = i;
    			break;
    		}
    	}
    	
    	if (index == -1) {
    		cart.getProducts().add(product);
    	} else {
    		if (product.getQuantity() != 0) {
    			cart.getProducts().set(index, product);
    		} else {
    			cart.getProducts().remove(index);
    		}
    	}
    	
    	cart.updateTotalPrice();
    	
    }

    /**
     * Vacía el carrito y restablece el usuario por defecto
     */
    public void clearCart() {
        this.cart.getProducts().clear();
        this.cart.setUser(getUserDefault());
        this.productQuantities.clear();
    }

    /**
     * Calcula el total de la compra
     * @return el total calculado
     */
    public double calculateTotal() {
        return this.cart.getProducts().stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
    
    public double getTotal() {
    	return cart.getTotalPrice();
    }

    /**
     * Obtiene el carrito actual
     * @return el carrito actual
     */
    public Cart getCart() {
        return this.cart;
    }
    
    /**
     * Establece el usuario del carrito
     * @param user el usuario a establecer
     */
    public void setUser(User user) {
    	this.cart.setUser(user);
    }

    /**
     * Obtiene las cantidades de productos en el carrito
     * @return mapa con las cantidades de cada producto
     */
    public Map<Product, Integer> getProductQuantities() {
        return new HashMap<>(productQuantities);
    }
    
    /**
     * Crea un usuario por defecto
     * @return usuario por defecto
     */
    private User getUserDefault() {
        User user = new User();

        user.setEmail("N/A");
        user.setIdUser("DESCONOCIDO");
        user.setLastName("N/A");
        user.setName("N/A");
        
        return user;
    }
}