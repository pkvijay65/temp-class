package interfaces;

/**
 * BankAccount implementing Payable interface.
 * Shows different implementation of the same interface.
 */
public class BankAccount implements Payable, Refundable {
    private double balance;
    private String accountNumber;
    private String bankName;

    public BankAccount(String accountNumber, String bankName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.balance = initialBalance;
    }

    @Override
    public void pay(double amount) {
        if (canPay(amount)) {
            balance -= amount;
            System.out.println("Debited " + Payable.formatCurrency(amount) +
                    " from " + bankName + " account " + maskAccountNumber());
            System.out.println("Available balance: " + Payable.formatCurrency(balance));
        } else {
            System.out.println("Transaction failed: Check balance or transaction limits");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public boolean processRefund(double amount) {
        System.out.println("Bank refund initiated...");
        System.out.println("Refund will be credited within 3-5 business days");
        // In real implementation, this would be async
        balance += amount;
        return true;
    }

    @Override
    public String getRefundPolicy() {
        return "Refunds processed within 3-5 business days";
    }

    private String maskAccountNumber() {
        if (accountNumber.length() >= 4) {
            return "XXXX" + accountNumber.substring(accountNumber.length() - 4);
        }
        return "XXXX";
    }

    public String getBankName() {
        return bankName;
    }
}
