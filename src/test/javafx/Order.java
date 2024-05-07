package test.javafx;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private int userId;
    private String status;
    private List<Book> items;
    private double totalPrice;
    private LocalDateTime orderDateTime;
    
    public Order(List<Book> items, double totalPrice) {
        this.items = items;
        this.totalPrice = totalPrice;
        this.orderDateTime = LocalDateTime.now();
    }
  
    public Order(int orderId, double d, String status) {
        this.orderId = orderId;
        this.userId = (int) d;
        this.status = status;
        this.items = new ArrayList<>();
        this.totalPrice = 0.0; // Initialize total price
        this.orderDateTime = LocalDateTime.now();
    }

    public Order(int orderId, int userId) {
        this.orderId = orderId;
        this.userId = userId;
        this.status = "Pending"; // Default status
        this.items = new ArrayList<>();
        this.totalPrice = 0.0; // Initialize total price
        this.orderDateTime = LocalDateTime.now();
    }
    // Getters and setters for all fields

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Book> getItems() {
        return items;
    }

    public void setItems(List<Book> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public void addItem(Book book) {
        items.add(book);
        totalPrice += book.getPrice(); // Update total price
    }

    public void printReceipt() {
        System.out.println("\nOrder Receipt");
        System.out.println("Date/Time: " + formatDateTime(orderDateTime));
        System.out.println("Total Price: $" + totalPrice);
        System.out.println("Items:");
        for (Book book : items) {
            System.out.println("- " + book.getTitle() + " | Price: $" + book.getPrice());
        }
        System.out.println("Thank you for your order!");
    }

    public void printItemizedOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("User ID: " + userId);
        System.out.println("Status: " + status);
        System.out.println("Items:");
        for (Book item : items) {
            System.out.println("- " + item.getTitle() + " | Price: $" + item.getPrice());
        }
        System.out.println("Total Items: " + items.size());
        System.out.println("Total Price: $" + totalPrice);
        System.out.println("Order Date/Time: " + formatDateTime(orderDateTime));
    }

    public String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
    }
}
