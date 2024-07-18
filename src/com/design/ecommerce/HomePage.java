package com.design.ecommerce;

import java.util.List;
import java.util.Scanner;

public class HomePage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample user
        User user = new User("john_doe", "password123");

        System.out.println("Welcome to the E-commerce application!");

        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                if (user.login(username, password)) {
                    System.out.println("Login successful!");

                    while (true) {
                        System.out.println("1. View Cart");
                        System.out.println("2. Add to Cart");
                        System.out.println("3. Checkout");
                        System.out.println("4. Logout");
                        int userChoice = scanner.nextInt();
                        scanner.nextLine();  // Consume newline

                        if (userChoice == 1) {
                            Cart cart = user.viewCart();
                            System.out.println("Cart Items: " + cart.getItems());
                            System.out.println("Total Price: $" + cart.getTotalPrice());
                            // Show discounts and reasons if any
                            Order tempOrder = new Order(cart.getItems());
                            new PriceObserver().update(tempOrder);
                            new QuantityObserver().update(tempOrder);
                            if (tempOrder.getDiscount() > 0) {
                                System.out.println("Discount Applied: $" + tempOrder.getDiscount());
                                System.out.println("Discount Reason: " + tempOrder.getDiscountReason());
                            }
                            System.out.println("Shipping Cost: $" + tempOrder.getShippingCost());
                        } else if (userChoice == 2) {
                            List<Item> availableItems = user.getAvailableItems();
                            System.out.println("Available Items:");
                            for (int i = 0; i < availableItems.size(); i++) {
                                System.out.println((i + 1) + ". " + availableItems.get(i));
                            }
                            System.out.print("Select an item to add to the cart: ");
                            int itemChoice = scanner.nextInt();
                            scanner.nextLine();  // Consume newline

                            if (itemChoice > 0 && itemChoice <= availableItems.size()) {
                                user.addToCart(availableItems.get(itemChoice - 1));
                                System.out.println("Item added to cart.");
                            } else {
                                System.out.println("Invalid choice.");
                            }
                        } else if (userChoice == 3) {
                            Order order = user.checkout();
                            System.out.println("Order placed successfully! Order ID: " + order.getId());
                            System.out.println("Order Details: " + order);
                        } else if (userChoice == 4) {
                            user.logout();
                            break;
                        }
                    }
                } else {
                    System.out.println("Invalid username or password.");
                }
            } else if (choice == 2) {
                break;
            }
        }

        scanner.close();
    }
}
