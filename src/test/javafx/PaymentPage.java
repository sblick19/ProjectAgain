package test.javafx;

import java.util.Scanner;
import java.util.List;
import java.util.Map;

public class PaymentPage {
    private Scanner scanner;
    private UserManager userManager;
    private BookInventory bookInventory;
    private ShoppingCart shoppingCart;
    private OrderManager orderManager;
    private MainStorePage mainStorePage;

    public PaymentPage(UserManager userManager, BookInventory bookInventory, ShoppingCart shoppingCart, MainStorePage mainStorePage) {
        this.userManager = userManager;
        this.bookInventory = bookInventory;
        this.shoppingCart = shoppingCart;
        this.orderManager = OrderManager.getInstance(); // Assuming OrderManager is a singleton
        this.mainStorePage = mainStorePage;
        this.scanner = new Scanner(System.in);
    }

    public void initiatePayment(User user) {
        System.out.println("Payment Options:");
        System.out.println("1) Credit Card");
        System.out.println("2) PayPal");

        System.out.print("Choose a payment method (1-2): ");
        int paymentChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (paymentChoice) {
            case 1:
                processCreditCardPayment(user);
                break;
            case 2:
                processPayPalPayment(user);
                break;
            default:
                System.out.println("Invalid payment method choice.");
                break;
        }
    }

    public void processCreditCardPayment(User user) {
        System.out.print("Enter credit card number: ");
        String cardNumber = scanner.nextLine();
        System.out.print("Enter expiration date (MM/YYYY): ");
        String expirationDate = scanner.nextLine();
        System.out.print("Enter CVV: ");
        String cvv = scanner.nextLine();

        CreditCardPayment creditCardPayment = new CreditCardPayment(cardNumber, expirationDate, cvv);
        creditCardPayment.processPayment(shoppingCart.calculateTotalPrice());
        completeOrder(user);
    }

    public void processPayPalPayment(User user) {
        System.out.print("Enter PayPal email: ");
        String email = scanner.nextLine();
        System.out.print("Enter PayPal password: ");
        String password = scanner.nextLine();

        PayPalPayment payPalPayment = new PayPalPayment(email, password);
        payPalPayment.processPayment(shoppingCart.calculateTotalPrice());
        completeOrder(user);
    }

    public void completeOrder(User user) {
        System.out.println("Order completed for user ID " + user.getUserId() + ".");
        List<Map.Entry<Book, Integer>> itemsPurchasedEntries = shoppingCart.getItems();
        double totalPrice = shoppingCart.calculateTotalPrice();

        System.out.println("\nItemized Order Receipt:");
        System.out.println("Items Purchased:");

        for (Map.Entry<Book, Integer> entry : itemsPurchasedEntries) {
            Book item = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(item.getTitle() + " | Quantity: " + quantity + " | Price: $" + (item.getPrice() * quantity));
        }

        System.out.println("Total Price: $" + totalPrice);
        System.out.println("Date/Time: " + java.time.LocalDateTime.now());

        // Reset the cart
        shoppingCart.clearCart();

        // Go back to the main store page
        mainStorePage.display(scanner);
    }}

