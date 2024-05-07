package test.javafx;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AdminPage {
    private UserManager userManager;
    private BookInventory bookInventory;
    private OrderManager orderManager;
    
    public AdminPage(UserManager userManager, BookInventory bookInventory, OrderManager orderManager) {
        this.userManager = userManager;
        this.bookInventory = bookInventory;
        this.orderManager = orderManager;
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Admin Page!");
        System.out.println("1) List all books");
        System.out.println("2) List book quantities");
        System.out.println("3) List all users");
        System.out.println("4) List all orders");
        System.out.println("5) List all payments");
        System.out.println("6) Total money made");
        System.out.println("7) Exit");

        try {
            System.out.print("Please enter your choice (1-7): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listAllBooks();
                    break;
                case 2:
                    listBookQuantities();
                    break;
                case 3:
                    listAllUsers();
                    break;
                case 4:
                    listAllOrders();
                    break;
                case 5:
                    listAllPayments();
                    break;
                case 6:
                    displayTotalMoneyMade();
                    break;
                case 7:
                    System.out.println("Exiting admin page...");
                    return;  // Exit the method if the user chooses to exit
                default:
                    System.out.println("Invalid choice. Please select 1-7.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input or unexpected error occurred.");
        } finally {
            scanner.close();  // Always close the scanner in a finally block to ensure proper resource management
        }
    }

    private void listAllBooks() {
        List<Book> books = bookInventory.getAllBooksList();
        System.out.println("List of all books:");
        for (Book book : books) {
            System.out.println(book);
        }
        // Automatically return to main options menu
    }

    private void listBookQuantities() {
        List<Book> books = bookInventory.getAllBooksList();
        System.out.println("List of book quantities:");
        for (Book book : books) {
            System.out.println(book.getTitle() + ": " + book.getStock());
        }
        // Automatically return to main options menu
    }

    private void listAllUsers() {
        Map<Integer, User> users = userManager.getAllUsers();
        System.out.println("List of all users:");
        for (Map.Entry<Integer, User> entry : users.entrySet()) {
            User user = entry.getValue();
            System.out.println("User ID: " + user.getUserId() +
                    ", Username: " + user.getUsername() +
                    ", Email: " + user.getEmail());
        }
        // Automatically return to main options menu
    }

    private void listAllOrders() {
        List<Order> orders = orderManager.getAllOrdersList();
        System.out.println("List of all orders:");
        for (Order order : orders) {
            System.out.println(order); // Assuming Order class has a suitable toString() method
        }
        // Automatically return to main options menu
    }

    private void listAllPayments() {
        Map<Integer, Order> orders = orderManager.getAllOrders();
        double totalMoney = 0.0;

        System.out.println("List of all payments:");
        for (Map.Entry<Integer, Order> entry : orders.entrySet()) {
            Order order = entry.getValue();
            if (order.getStatus().equals("Completed")) {
                double orderTotalPrice = order.getTotalPrice();
                totalMoney += orderTotalPrice;
                System.out.println("Order ID: " + order.getOrderId() + ", Total Price: $" + orderTotalPrice);
            }
        }
        System.out.println("Total money made from completed orders: $" + totalMoney);
        // Automatically return to main options menu
    }

    private void displayTotalMoneyMade() {
        double totalMoneyMade = calculateTotalMoneyMade();
        System.out.println("Total money made from completed orders: $" + totalMoneyMade);
        // Automatically return to main options menu
    }

    public double calculateTotalMoneyMade() {
        Map<Integer, Order> orders = orderManager.getAllOrders();
        double totalMoney = 0.0;

        for (Map.Entry<Integer, Order> entry : orders.entrySet()) {
            Order order = entry.getValue();
            if (order.getStatus().equals("Completed")) {
                totalMoney += order.getTotalPrice();
            }
        }

        return totalMoney;
    }
}
