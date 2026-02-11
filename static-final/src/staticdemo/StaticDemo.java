package staticdemo;

// Static import - use static members without class name
import java.sql.SQLOutput;

import static staticdemo.MathUtils.*;

/**
 * Main demo class for static keyword concepts.
 */
public class StaticDemo {
    public static void main(String[] args) {

        int maxValue = Math.max(5, 6);

        OuterClass outerClass = new OuterClass(15, 14);


        OuterClass.InnerClass innerClass = new OuterClass.InnerClass(12);
//        OuterClass.nonStaticInnerClass nonStaticInnerClass = new OuterClass.nonStaticInnerClass(15);

        OuterClass.nonStaticInnerClass nonStaticInnerClass1 = outerClass.new nonStaticInnerClass(15);

        //Can a method be abstract and static both?




//        System.out.println("=== Static Keyword Demo ===\n");
//
//        // 1. Static Variables
//        System.out.println("--- Static Variables (User Counter) ---");
//        System.out.println("Initial user count: " + User.getUserCount());
//
//        User u1 = new User("Alice", "alice@email.com");
//        User u2 = new User("Bob", "bob@email.com");
//        User u3 = new User("Charlie", "charlie@email.com");
//
//        System.out.println("Total users: " + User.getUserCount());
//        System.out.println("Can create more? " + User.canCreateMoreUsers());
//        System.out.println();
//
//        // 2. Instance vs Static Variables
//        System.out.println("--- Instance vs Static Variables ---");
//        Counter c1 = new Counter();
//        Counter c2 = new Counter();
//
//        c1.increment();
//        c1.increment();
//        c2.increment();
//
//        System.out.println("Counter 1:");
//        c1.displayCounts();
//        System.out.println("Counter 2:");
//        c2.displayCounts();
//        System.out.println("Notice: staticCount is same for both, instanceCount differs\n");
//
//        // 3. Static Methods (Utility Class)
//        System.out.println("--- Static Methods (MathUtils) ---");
//        // Without static import
//        System.out.println("5 + 3 = " + MathUtils.add(5, 3));
//        System.out.println("PI = " + MathUtils.PI);
//
//        // With static import (see import at top)
//        System.out.println("10 - 4 = " + subtract(10, 4));
//        System.out.println("2^10 = " + power(2, 10));
//        System.out.println("Is 17 prime? " + isPrime(17));
//        System.out.println("5! = " + factorial(5));
//        System.out.println();
//
//        // 4. Static Blocks
//        System.out.println("--- Static Blocks (DatabaseConfig) ---");
//        System.out.println("Accessing DatabaseConfig for the first time...");
//        System.out.println("Connection: " + DatabaseConfig.getConnectionString());
//        System.out.println("Max connections: " + DatabaseConfig.getMaxConnections());
//        System.out.println("Creating another reference (static blocks don't run again):");
//        DatabaseConfig config = new DatabaseConfig();
//        config.showConfig();
//        System.out.println();
//
//        // 5. Static Nested Class
//        System.out.println("--- Static Nested Class vs Inner Class ---");
//
//        // Creating static nested class - NO outer instance needed
//        University.Address address = new University.Address("Mumbai", "India", "400001");
//        address.displayAddress();
//
//        // Creating inner class - NEEDS outer instance
//        University mit = new University("MIT");
//        University.Student student = mit.new Student("John", 12345);
//        student.displayInfo();
//
//        // Using Builder (static nested class pattern)
//        University stanford = new University.Builder()
//                .name("Stanford University")
//                .build();
//        System.out.println("Built: " + stanford.getUniversityName());
//        System.out.println();
//
//        // 6. Method Hiding
//        System.out.println("--- Method Hiding Demo ---");
//        MethodHiding.main(new String[]{});
    }
}
