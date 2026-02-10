package interfaces;

/**
 * Interface demonstrating basic interface concepts.
 * All methods are implicitly public abstract.
 * All fields are implicitly public static final.
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
