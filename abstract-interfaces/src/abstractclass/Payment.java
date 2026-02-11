package abstractclass;

/**
 * LEARNING OUTCOME: Abstract Class Basics
 *
 * Key points:
 * - Cannot be instantiated directly (new Payment() = ERROR)
 * - Can have abstract methods (no body) AND concrete methods (with body)
 * - Can have constructors (called via super() from child)
 * - Use protected fields for child class access
 */
public abstract class Payment {
    protected double amount;
    protected String transactionId;

    public Payment(double amount) {
        this.amount = amount;
        this.transactionId = generateTransactionId();
    }

    // Abstract method - MUST be implemented by concrete subclasses
    public abstract void process();


    // Abstract method - child decides refund logic
    public boolean refund() {
        return true;
    }


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
