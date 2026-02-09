package polymorphism;

import inheritance.*;
import polymorphism.overriding.payment.*;

// Demonstrates Runtime Polymorphism - Dynamic Method Dispatch
public class DynamicDispatchDemo {

    public static void main(String[] args) {
        System.out.println("=== Dynamic Method Dispatch Demo ===\n");

        // Parent reference, different child objects
        User[] users = {
            new Customer("Alice", "alice@email.com", "123 Main St"),
            new Seller("Bob", "bob@email.com", "Bob's Store"),
            new Admin("Charlie", "charlie@email.com")
        };

        // Same method call, different behaviors!
        System.out.println("Calling getPermissions() on each user:");
        System.out.println("---");
        for (User u : users) {
            System.out.print(u.getClass().getSimpleName() + ": ");
            u.getPermissions();  // Resolved at RUNTIME based on actual object
        }

        System.out.println("\n=== Payment System Demo ===\n");

        Payment[] payments = {
            new Payment(100),
            new CreditCardPayment(100, "1234567890123456"),
            new UPIPayment(100, "user@paytm")
        };

        for (Payment p : payments) {
            System.out.println("--- " + p.getClass().getSimpleName() + " ---");
            p.process();
            System.out.println("Fee: $" + p.calculateFee());
            System.out.println("Total: $" + p.getTotal());
            System.out.println();
        }
    }
}
