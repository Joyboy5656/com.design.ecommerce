package com.design.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private Cart cart;
    private List<Order> orderHistory;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.cart = new Cart(this);
        this.orderHistory = new ArrayList<>();
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void logout() {
        // Implement logout functionality
    }

    public Cart viewCart() {
        return cart;
    }

    public void addToCart(Item item) {
        cart.addItem(item);
    }

    public Order checkout() {
        Order order = new Order(cart.getItems());
        order.attach(new PriceObserver());
        order.attach(new QuantityObserver());
        orderHistory.add(order);
        cart.clear();
        return order;
    }

    public List<Item> getAvailableItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Shirt", 60));
        items.add(new Item("Bag", 500));
        items.add(new Item("Shoes", 200));
        items.add(new Item("Socks", 10));
        items.add(new Item("Dress", 120));
        return items;
    }
}
