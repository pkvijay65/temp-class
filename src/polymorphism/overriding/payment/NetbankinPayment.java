package polymorphism.overriding.payment;

public class NetbankinPayment extends Payment{
    public NetbankinPayment(double amount) {
        super(amount);
    }

    @Override
    public void process() {
        System.out.println("NetbankinPayment process");
    }


}
