package test.javafx;

import java.util.List;
import java.util.Scanner;

public class OrderPage {
    private UserManager userManager;
    private User currentUser;
    private OrderManager orderManager;
    private MainStorePage mainStorePage;

    public OrderPage(UserManager userManager, User currentUser, OrderManager orderManager, MainStorePage mainStorePage) {
        this.userManager = userManager;
        this.currentUser = currentUser;
        this.orderManager = orderManager;
        this.mainStorePage = mainStorePage;
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);

        List<Order> userOrders = orderManager.getOrdersByUserId(currentUser.getUserId());

        System.out.println("Order Page");
        if (userOrders.isEmpty()) {
            System.out.println("No orders found.");
            System.out.println("Start a new order?");
            System.out.println("1) Yes");
            System.out.println("2) Go to Shop Page");
            System.out.println("3) Back to Main Store Page");
            int choice = scanner.nextInt();
            if (choice == 1) {
                // Logic to start a new order (not specified in the provided code)
            } else if (choice == 2) {
                // Logic to go to the Shop Page (not specified in the provided code)
            } else if (choice == 3) {
                System.out.println("Going back to main store page...");
                mainStorePage.display(scanner); // Pass the scanner to mainStorePage.display()
            }
        } else {
            System.out.println("Previous Orders:");
            for (Order order : userOrders) {
                System.out.println("Order ID: " + order.getOrderId());
                System.out.println("Number of Items: " + order.getItems().size());
                System.out.println("Total Cost: $" + order.getTotalPrice());
                System.out.println("------------------------");
            }

            System.out.print("Enter order ID to view details (0 to go back): ");
            int orderId = scanner.nextInt();
            if (orderId != 0) {
                Order selectedOrder = orderManager.findOrderById(orderId);
                if (selectedOrder != null) {
                    selectedOrder.printItemizedOrder();
                } else {
                    System.out.println("Order not found.");
                }
            } else {
                mainStorePage.display(scanner); // Pass the scanner to mainStorePage.display()
            }
        }

        scanner.close();
    }
}