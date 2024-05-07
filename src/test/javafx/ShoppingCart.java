package test.javafx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ShoppingCart {
    private Map<Book, Integer> items;  // Use Map to store book and quantity
    private User currentUser;
    private BookInventory bookInventory;
    private UserManager userManager;
    private MainStorePage mainStorePage;

    public ShoppingCart(User currentUser, BookInventory bookInventory, UserManager userManager, MainStorePage mainStorePage) {
        this.items = new HashMap<>();
        this.currentUser = currentUser;
        this.bookInventory = bookInventory;
        this.userManager = userManager;
        this.mainStorePage = mainStorePage;
    }

    public void addItem(Book book, int quantity) {
        if (items.containsKey(book)) {
            int currentQuantity = items.get(book);
            items.put(book, currentQuantity + quantity);  // Update quantity
        } else {
            items.put(book, quantity);  // Add new item
        }
        bookInventory.decreaseStock(book, quantity); // Decrease book stock in inventory
    }

    public int getTotalItems() {
        return items.size();
    }

    public List<Map.Entry<Book, Integer>> getItems() {
        return new ArrayList<>(items.entrySet());  // Return a copy of map entries
    }
    
    public void removeItem(Book book, int quantity) {
        if (items.containsKey(book)) {
            int currentQuantity = items.get(book);
            if (quantity >= currentQuantity) {
                items.remove(book);  // Remove item if quantity is equal or more than what's in cart
                bookInventory.increaseStock(book, currentQuantity);  // Increase book stock in inventory
            } else {
                items.put(book, currentQuantity - quantity);  // Update quantity
                bookInventory.increaseStock(book, quantity);  // Increase book stock in inventory
            }
            System.out.println("Item removed from cart.");
        } else {
            System.out.println("Item not found in cart.");
        }
    }

    public void clearCart() {
        for (Map.Entry<Book, Integer> entry : items.entrySet()) {
            Book book = entry.getKey();
            int quantity = entry.getValue();
            bookInventory.increaseStock(book, quantity);  // Increase all book quantities in inventory
        }
        items.clear();
        System.out.println("Cart cleared.");
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Map.Entry<Book, Integer> entry : items.entrySet()) {
            Book book = entry.getKey();
            int quantity = entry.getValue();
            totalPrice += (book.getPrice() * quantity);  // Calculate total price based on quantity
        }
        return totalPrice;
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nShopping Cart");
            System.out.println("Items in Cart:");

            int itemIndex = 1;
            for (Map.Entry<Book, Integer> entry : items.entrySet()) {
                Book book = entry.getKey();
                int quantity = entry.getValue();
                System.out.println(itemIndex + ") " + book.getTitle() + " | Quantity: " + quantity + " | Price: $" + (book.getPrice() * quantity));
                itemIndex++;
            }

            System.out.println("Total Price: $" + calculateTotalPrice());
            System.out.println("1) Complete Order");
            System.out.println("2) Remove Item");
            System.out.println("3) Clear Cart");
            System.out.println("4) Back");

            System.out.print("Please enter your choice (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    initiatePayment(currentUser);
                    break;
                case 2:
                    System.out.print("Enter item index to remove: ");
                    int index = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if (index >= 1 && index <= items.size()) {
                        Book[] bookArray = items.keySet().toArray(new Book[0]);
                        Book selectedBook = bookArray[index - 1];
                        System.out.print("Enter quantity to remove: ");
                        int quantityToRemove = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        removeItem(selectedBook, quantityToRemove);
                    } else {
                        System.out.println("Invalid item index.");
                    }
                    break;
                case 3:
                    clearCart();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-4.");
            }
        }

        scanner.close();
    }

    public void initiatePayment(User user) {
        PaymentPage paymentPage = new PaymentPage(userManager, bookInventory, this, mainStorePage); // Pass BookInventory, UserManager, and ShoppingCart
        paymentPage.initiatePayment(user);
    }
}
