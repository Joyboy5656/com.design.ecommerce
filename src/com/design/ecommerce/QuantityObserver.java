package com.design.ecommerce;

public class QuantityObserver implements OrderObserver {
    @Override
    public void update(Order order) {
        if (order.getCount() > 5) {
            order.setShippingCost(0);
        } else {
            order.setShippingCost(10);
        }
    }
}
