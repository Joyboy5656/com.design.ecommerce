This Project consist in the practice a Behavioral design pattern and upload your code to GitHub using Version Control. 
We are building an e-commerce application where clients can create orders and update them by adding items to the order created. 
When an order is updated, two monitors a Price monitor, and a Quantity monitor get notified and perform the following action:
1. If the cost of the order is more than $200, the Price monitor provides a $20 discount and updates the order's total price by subtracting the discount amount.
2. If the quantity of items in the order is more than 5, the Quantity monitor sets the shipping cost of the order to zero otherwise the default shipping cost is $10.
