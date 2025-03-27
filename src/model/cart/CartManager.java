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

    public CartManager(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        this.cart = new Cart();
        this.cart.setUser(user);
        this.cart.setProducts(new ArrayList<>());
        this.cart.setCheckout(false);
        this.productQuantities = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        for (int i = 0; i < quantity; i++) {
            this.cart.getProducts().add(product);
        }
        productQuantities.merge(product, quantity, Integer::sum);
    }

    public void removeProduct(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }

        int currentQuantity = productQuantities.getOrDefault(product, 0);
        if (currentQuantity < quantity) {
            throw new IllegalArgumentException("Cannot remove more items than exist in cart");
        }

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
        this.productQuantities.clear();
    }

    public double calculateTotal() {
        return this.cart.getProducts().stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public boolean checkout() {
        if (this.cart.getProducts().isEmpty()) {
            throw new IllegalStateException("Cannot checkout an empty cart");
        }

        try {
            this.cart.setCheckout(true);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Cart getCart() {
        return this.cart;
    }

    public Map<Product, Integer> getProductQuantities() {
        return new HashMap<>(productQuantities);
    }
}