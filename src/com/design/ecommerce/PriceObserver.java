package com.design.ecommerce;

public class PriceObserver implements OrderObserver {
    @Override
    public void update(Order order) {
        if (order.getTotalPrice() > 200) {
            double discountedPrice = order.getTotalPrice() - 20;
            order.setTotalPrice(discountedPrice);
        }
    }
}
