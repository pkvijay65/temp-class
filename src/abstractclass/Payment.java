package abstractclass;

/**
 * Abstract class demonstrating:
 * - Abstract methods (no implementation)
 * - Concrete methods (with implementation)
 * - Constructor in abstract class
 * - Protected fields for child access
 */
public abstract class Payment {
    protected double amount;
    protected String transactionId;

    // Constructor - called via super() from child classes
    public Payment(double amount) {
        this.amount = amount;
        this.transactionId = generateTransactionId();
    }

    // Abstract method - MUST be implemented by concrete subclasses
    public abstract void process();

    // Abstract method - child decides refund logic
    public abstract boolean refund();

    // Concrete method - shared implementation
    public void printReceipt() {
        System.out.println("=== Payment Receipt ===");
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Amount: $" + amount);
        System.out.println("=======================");
    }

    // Concrete method - can be overridden but doesn't have to be
    public double calculateFee() {
        return 0; // Default: no fee
    }

    // Final method - cannot be overridden
    public final double getTotal() {
        return amount + calculateFee();
    }

    // Private helper - not visible to children
    private String generateTransactionId() {
        return "TXN" + System.currentTimeMillis();
    }

    // Getters
    public double getAmount() {
        return amount;
    }

    public String getTransactionId() {
        return transactionId;
    }
}
