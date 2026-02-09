package inheritance;

public class Customer extends User {
    private String shippingAddress;

    public Customer(String name, String email, String shippingAddress) {
        super(name, email);  // MUST be first line
        this.shippingAddress = shippingAddress;
    }

    public Customer(String name, String email) {
        super(name, email);
    }

    public void placeOrder(int items) {
        while (items > 0) {
//            System.out.println(name + " placed an order to: " + shippingAddress);
            placeOrder();
            items--;
        }
    }


    public void placeOrder() {
        System.out.println(name + " placed an order to: " + shippingAddress);
    }

    @Override
    public void login() {
        super.login();  // Call parent's login first
        System.out.println("Loading cart...");
    }

    @Override
    public void getPermissions() {
        System.out.println("Customer access: browse, cart, orders");
    }


}
