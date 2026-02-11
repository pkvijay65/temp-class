package inheritance;

/**
 * LEARNING OUTCOME: Inheritance & Method Overriding
 *
 * Customer IS-A User, inherits all User's members,
 * and can override methods for custom behavior.
 */
public class Customer extends User {
    private String shippingAddress;

    public Customer(String name, String email, String shippingAddress) {
        super(name, email);  // MUST be first line
        this.shippingAddress = shippingAddress;
    }

    public Customer(String name, String email) {
        super(name, email);
    }

    // Customer-specific method
    public void placeOrder() {
        System.out.println(name + " placed an order to: " + shippingAddress);
    }

    // Overloaded method
    public void placeOrder(int items) {
        for (int i = 0; i < items; i++) {
            placeOrder();
        }
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
