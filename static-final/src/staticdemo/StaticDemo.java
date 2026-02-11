package staticdemo;

import static staticdemo.MathUtils.*;

/**
 * LEARNING OUTCOME: Static Keyword - Complete Demo
 *
 * Run this to see all static concepts in action:
 * 1. Static Variables (shared across instances)
 * 2. Static Methods (utility methods)
 * 3. Static Blocks (one-time initialization)
 * 4. Static Nested Classes
 */
public class StaticDemo {
    public static void main(String[] args) {
        System.out.println("=== Static Keyword Demo ===\n");

        // 1. Static Variables
        System.out.println("--- Static Variables (User Counter) ---");
        System.out.println("Initial user count: " + User.getUserCount());

        User u1 = new User("Alice", "alice@email.com");
        User u2 = new User("Bob", "bob@email.com");
        User u3 = new User("Charlie", "charlie@email.com");

        System.out.println("Total users: " + User.getUserCount());
        System.out.println("Can create more? " + User.canCreateMoreUsers());
        System.out.println();

        // 2. Instance vs Static Variables
        System.out.println("--- Instance vs Static Variables ---");
        Counter c1 = new Counter();
        Counter c2 = new Counter();

        c1.increment();
        c1.increment();
        c2.increment();

        System.out.println("Counter 1:");
        c1.displayCounts();
        System.out.println("Counter 2:");
        c2.displayCounts();
        System.out.println("Notice: staticCount is same for both, instanceCount differs\n");

        // 3. Static Methods (Utility Class)
        System.out.println("--- Static Methods (MathUtils) ---");
        System.out.println("5 + 3 = " + MathUtils.add(5, 3));
        System.out.println("PI = " + MathUtils.PI);

        // With static import (see import at top)
        System.out.println("10 - 4 = " + subtract(10, 4));
        System.out.println("2^10 = " + power(2, 10));
        System.out.println("Is 17 prime? " + isPrime(17));
        System.out.println("5! = " + factorial(5));
        System.out.println();

        // 4. Static Blocks
        System.out.println("--- Static Blocks (DatabaseConfig) ---");
        System.out.println("Accessing DatabaseConfig for the first time...");
        System.out.println("Connection: " + DatabaseConfig.getConnectionString());
        System.out.println("Max connections: " + DatabaseConfig.getMaxConnections());
        System.out.println();

        // 5. Static Nested Class
        System.out.println("--- Static Nested Class vs Inner Class ---");

        // Static nested class - NO outer instance needed
        University.Address address = new University.Address("Mumbai", "India", "400001");
        address.displayAddress();

        // Inner class - NEEDS outer instance
        University mit = new University("MIT");
        University.Student student = mit.new Student("John", 12345);
        student.displayInfo();
        System.out.println();

        // 6. Method Hiding
        System.out.println("--- Method Hiding Demo ---");
        MethodHiding.main(new String[]{});
    }
}
