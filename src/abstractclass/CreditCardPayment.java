package abstractclass;

/**
 * Concrete implementation of Payment for credit cards.
 * Must implement all abstract methods from Payment.
 */
public class CreditCardPayment extends Payment {
    private String cardNumber;
    private String cardHolderName;
    private static final double PROCESSING_FEE_PERCENT = 2.5;

    public CreditCardPayment(double amount, String cardNumber, String cardHolderName) {
        super(amount); // Call abstract class constructor
        this.cardNumber = maskCardNumber(cardNumber);
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void process() {
        System.out.println("Processing credit card payment...");
        System.out.println("Card: " + cardNumber);
        System.out.println("Holder: " + cardHolderName);
        System.out.println("Charging $" + getTotal() + " (includes $" + calculateFee() + " fee)");
        System.out.println("Payment successful!");
    }

    @Override
    public boolean refund() {
        System.out.println("Initiating credit card refund...");
        System.out.println("Refunding $" + amount + " to card " + cardNumber);
        // In real implementation, this would call payment gateway
        return true;
    }

    @Override
    public double calculateFee() {
        return amount * PROCESSING_FEE_PERCENT / 100;
    }

    private String maskCardNumber(String cardNumber) {
        if (cardNumber.length() >= 4) {
            return "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
        }
        return "****";
    }
}
