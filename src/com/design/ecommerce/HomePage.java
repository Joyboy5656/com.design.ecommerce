package com.design.ecommerce;

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
                        scanner.nextLine();

                        if (userChoice == 1) {
                            System.out.println("Cart: " + user.viewCart().getItems());
                        } else if (userChoice == 2) {
                            System.out.print("Enter item name: ");
                            String itemName = scanner.nextLine();
                            System.out.print("Enter item price: ");
                            double itemPrice = scanner.nextDouble();
                            scanner.nextLine();  // Consume newline
                            Item item = new Item(itemName, itemPrice);
                            user.addToCart(item);
                        } else if (userChoice == 3) {
                            user.checkout();
                            System.out.println("Order placed successfully!");
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
