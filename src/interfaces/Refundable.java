package interfaces;

/**
 * Interface for refund capability.
 * Demonstrates multiple interface implementation.
 */
public interface Refundable {
    boolean processRefund(double amount);

    String getRefundPolicy();

    // Default method
    default void printRefundPolicy() {
        System.out.println("Refund Policy: " + getRefundPolicy());
    }
}
