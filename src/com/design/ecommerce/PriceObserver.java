package com.design.ecommerce;

public class PriceObserver implements OrderObserver {
    @Override
    public void update(Order order) {
        if (order.getTotalPrice() > 200) {
            double discount = 20;
            double discountedPrice = order.getTotalPrice() - discount;
            order.setTotalPrice(discountedPrice);
            order.applyDiscount(discount, "Applied $20 discount for orders over $200.");
        }
    }
}
