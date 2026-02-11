package polymorphism.overriding.payment;

/**
 * LEARNING OUTCOME: Abstract Class as Base for Polymorphism
 *
 * This abstract class defines the contract for all payment types.
 * Subclasses MUST implement process() but inherit calculateFee() and getTotal().
 */
public abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    // Abstract method - each payment type implements differently
    public abstract void process();

    // Concrete method - can be overridden by subclasses
    public double calculateFee() {
        return 0;
    }

    // Concrete method - uses calculateFee() which may be overridden
    public double getTotal() {
        return amount + calculateFee();
    }

    // Getter for amount
    public double getAmount() {
        return amount;
    }
}
