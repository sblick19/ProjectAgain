package test.javafx;
public class PayPalPayment implements PaymentMethod {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void processPayment(double amount) {
        // Mock processing, no actual validation
        System.out.println("Processing PayPal payment of $" + amount);
        System.out.println("Payment processed successfully!");
    }
}
