import inheritance.*;
import polymorphism.overriding.payment.*;
import constructorchain.ConstructorChainDemo;

/**
 * LEARNING OUTCOME: Inheritance & Polymorphism - Complete Demo
 *
 * Run this file to see all concepts in action:
 * 1. Basic Inheritance (User -> Customer, Seller, Admin)
 * 2. Constructor Chaining (super() calls)
 * 3. Method Overriding (getPermissions())
 * 4. Runtime Polymorphism (Payment system)
 */
public class Main {

    public static void main(String[] args) {
        demo1_BasicInheritance();
        demo2_ConstructorChaining();
        demo3_MethodOverriding();
        demo4_RuntimePolymorphism();
    }

    static void demo1_BasicInheritance() {
        System.out.println("=== DEMO 1: Basic Inheritance ===\n");
        System.out.println("Customer IS-A User, so it inherits login() and logout()\n");

        Customer customer = new Customer("Alice", "alice@mail.com", "123 Main St");
        customer.login();      // Inherited from User
        customer.placeOrder(); // Customer's own method
        customer.logout();     // Inherited from User

        System.out.println("\n" + "=".repeat(50) + "\n");
    }

    static void demo2_ConstructorChaining() {
        System.out.println("=== DEMO 2: Constructor Chaining ===\n");
        System.out.println("When creating a Child, Parent constructor runs FIRST!\n");

        // This will show: A -> B -> C order
        ConstructorChainDemo.main(new String[]{});

        System.out.println("\n" + "=".repeat(50) + "\n");
    }

    static void demo3_MethodOverriding() {
        System.out.println("=== DEMO 3: Method Overriding ===\n");
        System.out.println("Same method name, different implementation in each class\n");

        User user = new User("Generic", "user@mail.com");
        Admin admin = new Admin("Super", "admin@mail.com");

        System.out.print("User.getPermissions(): ");
        user.getPermissions();

        System.out.print("Admin.getPermissions(): ");
        admin.getPermissions();

        System.out.println("\n" + "=".repeat(50) + "\n");
    }

    static void demo4_RuntimePolymorphism() {
        System.out.println("=== DEMO 4: Runtime Polymorphism ===\n");

        // --- Example 1: User hierarchy ---
        System.out.println("--- User Hierarchy ---");
        System.out.println("Reference type: User[], Actual objects: Customer, Seller, Admin\n");

        User[] users = {
            new Customer("Alice", "a@mail.com", "Address 1"),
            new Seller("Bob", "b@mail.com", "Bob's Shop"),
            new Admin("Charlie", "c@mail.com")
        };

        for (User u : users) {
            System.out.print(u.getClass().getSimpleName() + ".getPermissions() -> ");
            u.getPermissions();
        }

        // --- Example 2: Payment system ---
        System.out.println("\n--- Payment System ---");
        System.out.println("Reference type: Payment[], Actual objects: CreditCard, UPI, Netbanking\n");

        Payment[] payments = {
            new CreditCardPayment(100.00, "4532015112830366"),
            new UPIPayment(50.00, "user@upi"),
            new NetbankingPayment(200.00, "HDFC", "123456789")
        };

        for (Payment p : payments) {
            System.out.println("Processing " + p.getClass().getSimpleName() + ":");
            p.process();
            System.out.println("Fee: $" + String.format("%.2f", p.calculateFee()));
            System.out.println();
        }

        System.out.println("KEY INSIGHT: One loop processes ALL payment types!");
        System.out.println("This is the power of polymorphism - write once, works for all subclasses.");
    }
}
