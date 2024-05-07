package test.javafx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderManager {
    private static OrderManager instance = null;
    private List<Order> orders;
    private int lastOrderId;

    public OrderManager() {
        orders = new ArrayList<>();
    }

    public static OrderManager getInstance() {
        if (instance == null) {
            synchronized (OrderManager.class) {
                if (instance == null) {
                    instance = new OrderManager();
                }
            }
        }
        return instance;
    }

    public void createOrder(int userId, List<Book> items) {
        int orderId = generateOrderId(); // Assuming you have a method to generate unique order IDs
        Order order = new Order(items, 0.0); // Initialize order with items and totalPrice as 0
        order.setOrderId(orderId);
        order.setUserId(userId);
        orders.add(order);
        System.out.println("Order created with ID: " + orderId);
    }

    public void updateOrderStatus(int orderId, String status) {
        Order order = findOrderById(orderId);
        if (order != null) {
            order.setStatus(status);
            System.out.println("Order status updated: " + status);
        } else {
            System.out.println("Order not found.");
        }
    }

    public Map<Integer, Order> getAllOrders() {
        Map<Integer, Order> orderMap = new HashMap<>();
        for (Order order : orders) {
            orderMap.put(order.getOrderId(), order);
        }
        return orderMap;
    }

    public Order findOrderById(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }

    public List<Order> getOrdersByUserId(int userId) {
        List<Order> userOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getUserId() == userId) {
                userOrders.add(order);
            }
        }
        return userOrders;
    }

    public List<Order> getAllOrdersList() {
        return new ArrayList<>(orders); // Return a copy of the orders list
    }

    private int generateOrderId() {
        return ++lastOrderId; // Increment lastOrderId and return the new ID
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders); // Return a copy of the order list to prevent direct modification
    }
}
