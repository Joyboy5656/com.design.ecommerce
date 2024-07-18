package com.design.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderObserver> observers = new ArrayList<>();
    private List<Item> items;
    private double totalPrice;
    private int itemCount;
    private double shippingCost = 10.0;
    private double discount = 0.0;
    private String discountReason = "";

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

    public double getShippingCost() {
        return shippingCost;
    }

    public double getDiscount() {
        return discount;
    }

    public String getDiscountReason() {
        return discountReason;
    }

    public void applyDiscount(double discount, String reason) {
        this.discount = discount;
        this.discountReason = reason;
    }

    @Override
    public String toString() {
        return "Order [totalPrice=" + totalPrice + ", itemCount=" + itemCount + ", shippingCost=" + shippingCost +
                ", discount=" + discount + ", discountReason='" + discountReason + "']";
    }
}
