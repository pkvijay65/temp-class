package polymorphism;

public class UPIPayment extends Payment {
    private String upiId;

    public UPIPayment(double amount, String upiId) {
        super(amount);
        this.upiId = upiId;
    }

    public void process() {
        System.out.println("UPI transfer to: " + upiId);
    }

    public void upiSpecificMethod(){
        System.out.println("UPI transfer to: " + upiId);
    }

    // No override of calculateFee() - inherits 0 fee from parent!
}
