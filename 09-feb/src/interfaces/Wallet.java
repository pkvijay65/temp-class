package interfaces;

/**
 * Wallet class implementing multiple interfaces.
 * Demonstrates:
 * - Multiple interface implementation
 * - @Override annotation
 * - Using interface default methods
 */
public class Wallet implements Payable, Refundable {
    private double balance;
    private String walletId;

    public Wallet(String walletId, double initialBalance) {
        this.walletId = walletId;
        this.balance = initialBalance;
    }

    // From Payable interface
    @Override
    public void pay(double amount) {
        if (canPay(amount)) {
            balance -= amount;
            System.out.println("Paid " + Payable.formatCurrency(amount) + " from wallet " + walletId);
            System.out.println("Remaining balance: " + Payable.formatCurrency(balance));
        } else {
            System.out.println("Payment failed: Insufficient balance or exceeds limit");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    // From Refundable interface
    @Override
    public boolean processRefund(double amount) {
        balance += amount;
        System.out.println("Refund of " + Payable.formatCurrency(amount) + " processed to wallet");
        return true;
    }

    @Override
    public String getRefundPolicy() {
        return "Instant refund to wallet balance";
    }

    // Additional methods specific to Wallet
    public void addMoney(double amount) {
        balance += amount;
        System.out.println("Added " + Payable.formatCurrency(amount) + " to wallet");
    }

    public String getWalletId() {
        return walletId;
    }
}
