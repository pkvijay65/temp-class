package polymorphism.overriding.payment;

/**
 * LEARNING OUTCOME: Method Overriding
 *
 * UPIPayment overrides process() from Payment
 * to provide UPI-specific implementation.
 */
public class UPIPayment extends Payment {
    private String upiId;

    public UPIPayment(double amount, String upiId) {
        super(amount);
        this.upiId = upiId;
    }

    @Override
    public void process() {
        System.out.println("Processing UPI payment of $" + amount);
        System.out.println("UPI ID: " + upiId);
        System.out.println("Sending payment request...");
        System.out.println("Payment successful!");
    }

    // No override of calculateFee() - inherits 0 fee from parent
}
