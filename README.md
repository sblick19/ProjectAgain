# ProjectAgain

Book Store Project Overview  - Sophie Blick
The book store project is a Java application that simulates a digital bookstore where users can browse, search for, and purchase books. The project focuses on implementing core functionalities related to managing books, user accounts, and orders within the bookstore system. The user sees menus in the terminal for a simplistic experience.
Core Features
Book Inventory Management:
Implement functionalities to manage the bookstore's inventory, including adding new books, updating book information (e.g., title, author, genre, price), and deleting books. 
Organize books into categories or genres for easier browsing. 
User Account Management:
Allow users to create accounts, log in, and manage their profiles (e.g., update personal information, change password).
Implement authentication and authorization mechanisms to control access to certain features based on user roles.
Shopping Cart and Checkout:
Enable users to add books to their shopping cart, view the cart contents, update quantities, and remove items.
Implement a checkout process where users can review their orders, enter shipping information (optional for simulation), and complete the purchase.
Search and Filtering:
Provide robust search and filtering functionalities to help users find books easily.
Allow users to search for books by title, author, and genre. 
Order Management:
Manage user orders, including order creation, updating items in the order and posting a time stamp and itemized receipt when completed.
Generate unique order numbers for each order for management.



Some important classes:

Book Class:
Represents individual books with attributes like title, author, genre, price, etc.
Design Pattern: Plain Old Java Object (POJO)
BookInventory Class:
Manages the inventory of books, including adding, updating, and deleting books.
Design Pattern: Singleton (ensures only one instance of the inventory is created)
User Class:
Represents user accounts with attributes such as username, password, email, etc.
Design Pattern: POJO
UserManager Class:
Manages user accounts, including authentication, creation, and profile updates.
Design Pattern: Singleton
ShoppingCart Class:
Represents a user's shopping cart with functionalities to add, remove, and update items.
Design Pattern: POJO
Order Class:
Represents an order placed by a user with details like order number, items, total amount, etc.
Design Pattern: POJO
OrderManager Class:
Manages user orders, including order creation, payment status updates, and order history.
Design Pattern: Singleton
PaymentPage Class:
Handles payment processing operations such as charging credit cards, verifying payments, etc.
Design Pattern: Strategy (allows using different payment processing algorithms)
ShopPage Class:
Implements book search functionality based on various criteria like title, author, genre, etc.
Design Pattern: Strategy (allows using different search algorithms)

