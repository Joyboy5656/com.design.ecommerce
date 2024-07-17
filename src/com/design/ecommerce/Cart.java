package com.design.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items;
    private User user;

    public Cart(User user) {
        this.user = user;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }

    public int getTotalQuantity() {
        return items.size();
    }

    public List<Item> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }
}
