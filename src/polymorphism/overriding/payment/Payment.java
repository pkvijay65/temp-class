package polymorphism.overriding.payment;

// Base class for Payment system
public class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public void process() {

    }

    public double calculateFee() {
        return 0;
    }

    public double getTotal() {
        return amount + calculateFee();
    }
}
