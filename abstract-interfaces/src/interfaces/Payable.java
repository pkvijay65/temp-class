package interfaces;

/**
 * LEARNING OUTCOME: Interface Basics
 *
 * Key points:
 * - All methods are implicitly public abstract (unless default/static)
 * - All fields are implicitly public static final (constants)
 * - Java 8+ allows default methods (with implementation)
 * - Java 8+ allows static methods (utility methods)
 */
public interface Payable {
    // Constant (implicitly public static final)
    double MAX_TRANSACTION_LIMIT = 100000.00;

    // Abstract method (implicitly public abstract)
    void pay(double amount);

    double getBalance();

    // Default method (Java 8+) - has implementation
    default void payWithFee(double amount, double feePercent) {
        double fee = amount * feePercent / 100;
        double total = amount + fee;
        System.out.println("Fee: $" + fee);
        pay(total);
    }

    // Default method for validation
    default boolean canPay(double amount) {
        return getBalance() >= amount && amount <= MAX_TRANSACTION_LIMIT;
    }

    // Static method (Java 8+) - utility method
    static String formatCurrency(double amount) {
        return String.format("$%.2f", amount);
    }
}
