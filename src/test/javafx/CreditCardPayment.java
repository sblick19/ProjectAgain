package test.javafx;

public class CreditCardPayment implements PaymentMethod {
    private String cardNumber;
    private String expirationDate;
    private String cvv;

    public CreditCardPayment(String cardNumber, String expirationDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }
    
    //
    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getCvv() {
        return cvv;
    }

    @Override
    public void processPayment(double amount) {
        // Mock processing, no actual validation
        System.out.println("Processing credit card payment of $" + amount);
        System.out.println("Payment processed successfully!");
    }
}
