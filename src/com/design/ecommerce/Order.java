package com.design.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderObserver> observers = new ArrayList<>();
    private List<Item> items;
    private double totalPrice;
    private int itemCount;
    private double shippingCost = 10.0;

    public Order(List<Item> items) {
        this.items = new ArrayList<>(items);
        this.totalPrice = items.stream().mapToDouble(Item::getPrice).sum();
        this.itemCount = items.size();
        notifyObservers();
    }

    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getCount() {
        return itemCount;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order [totalPrice=" + totalPrice + ", itemCount=" + itemCount + ", shippingCost=" + shippingCost + "]";
    }
}
