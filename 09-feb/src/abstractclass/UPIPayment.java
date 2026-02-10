package abstractclass;

/**
 * Concrete implementation of Payment for UPI.
 * Demonstrates different implementation of abstract methods.
 */
public class UPIPayment extends Payment {
    private String upiId;
    private String pin;

    public UPIPayment(double amount, String upiId) {
        super(amount);
        this.upiId = upiId;
    }

    @Override
    public void process() {
        System.out.println("Processing UPI payment...");
        System.out.println("UPI ID: " + upiId);
        System.out.println("Amount: $" + amount);
        System.out.println("Sending payment request...");
        System.out.println("Payment successful!");
    }

    @Override
    public boolean refund() {
        System.out.println("UPI refunds are processed within 3-5 business days");
        System.out.println("Refunding $" + amount + " to " + upiId);
        return true;
    }

    // UPI has no processing fee, so we use default from parent
    // No need to override calculateFee()

    public void setPin(String pin) {
        this.pin = pin;
    }
}
