package polymorphism.overriding.payment;

public class CreditCardPayment extends Payment {
    private String cardNumber;

    public CreditCardPayment(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }

    @Override
    public void process() {
        System.out.println("Processing credit card payment of $" + amount);
        // Show only last 4 digits for security
        System.out.println("Charging card: ****" + cardNumber.substring(cardNumber.length() - 4));
    }

    @Override
    public double calculateFee() {
        return amount * 0.029;  // 2.9% fee
    }
}
