package polymorphism;

// Base class for Payment system
public class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public void process() {
        System.out.println("Processing payment of $" + amount);
    }

    public double calculateFee() {
        return 0;  // Base: no fee
    }

    public double getTotal() {
        return amount + calculateFee();
    }
}
