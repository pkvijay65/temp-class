package polymorphism.overriding.payment;

/**
 * LEARNING OUTCOME: Method Overriding
 *
 * This class overrides process() from Payment to provide
 * netbanking-specific implementation.
 */
public class NetbankingPayment extends Payment {
    private String bankName;
    private String accountNumber;

    public NetbankingPayment(double amount, String bankName, String accountNumber) {
        super(amount);
        this.bankName = bankName;
        this.accountNumber = maskAccountNumber(accountNumber);
    }

    @Override
    public void process() {
        System.out.println("Processing netbanking payment of $" + amount);
        System.out.println("Bank: " + bankName);
        System.out.println("Account: " + accountNumber);
        System.out.println("Redirecting to bank's secure portal...");
        System.out.println("Payment successful!");
    }

    @Override
    public double calculateFee() {
        return 0;  // Netbanking usually has no fee
    }

    private String maskAccountNumber(String accountNumber) {
        if (accountNumber.length() >= 4) {
            return "XXXX" + accountNumber.substring(accountNumber.length() - 4);
        }
        return "XXXX";
    }
}
