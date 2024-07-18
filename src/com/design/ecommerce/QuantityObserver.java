package com.design.ecommerce;

public class QuantityObserver implements OrderObserver {
    @Override
    public void update(Order order) {
        if (order.getCount() > 5) {
            order.setShippingCost(0);
            order.applyDiscount(10, "Free shipping for orders with more than 5 items.");
        }
    }
}
