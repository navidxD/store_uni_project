package model.cart;

import model.base.BasePersistence;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.product.Product;
import model.user.User;

public class CartManager extends BasePersistence<Cart> {
    private Cart cart;
    private Map<Product, Integer> productQuantities;

    @Override
    public void init() {
        // TODO Auto-generated method stub

    }

    public void startSale() {
        ArrayList<Product> products = new ArrayList<Product>();

        this.cart.setUser(getUserDefault());
        this.cart.setProducts(products);
    }
    
    public void completeSale() {
    	add(cart);
    }

    public void addProduct(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.cart.getProducts().add(product);
        }
        productQuantities.merge(product, quantity, Integer::sum);
    }

    public void removeProduct(Product product, int quantity) {
        int currentQuantity = productQuantities.getOrDefault(product, 0);

        for (int i = 0; i < quantity; i++) {
            this.cart.getProducts().remove(product);
        }

        if (currentQuantity == quantity) {
            productQuantities.remove(product);
        } else {
            productQuantities.put(product, currentQuantity - quantity);
        }
    }

    public void clearCart() {
        this.cart.getProducts().clear();
        this.cart.setUser(getUserDefault());
        this.productQuantities.clear();
    }

    public double calculateTotal() {
        return this.cart.getProducts().stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public Cart getCart() {
        return this.cart;
    }
    
    public void setUser(User user) {
    	this.cart.setUser(user);
    }

    public Map<Product, Integer> getProductQuantities() {
        return new HashMap<>(productQuantities);
    }
    
    private User getUserDefault() {
        User user = new User();

        user.setEmail("N/A");
        user.setIdUser("DESCONOCIDO");
        user.setLastName("N/A");
        user.setName("N/A");
        
        return user;
    }
}