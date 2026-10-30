package org.example;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    public List<Product> cart = new ArrayList<>();

    public void addToCart(Product product) {
        cart.add(product);
    }
    public void removeFromCart(Product product) {
        cart.remove(product);
    }

    public double getCartTotal() {
        double total = 0;

        for (int i = 0; i < cart.size(); i++) {
            Product p = cart.get(i);
            total += p.getPrice();
        }
        return total;
        }
    }

