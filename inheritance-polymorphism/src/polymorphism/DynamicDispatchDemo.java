package polymorphism;

import polymorphism.overriding.payment.*;

/**
 * LEARNING OUTCOME: Runtime Polymorphism (Dynamic Method Dispatch)
 *
 * Key points:
 * - Reference type decides what you CAN call (compile-time)
 * - Object type decides what ACTUALLY runs (runtime)
 * - This is the power of polymorphism - same code, different behavior
 */
public class DynamicDispatchDemo {

    public static void main(String[] args) {
        System.out.println("=== Dynamic Method Dispatch Demo ===\n");

        // 1. Basic Example: Reference vs Object type
        System.out.println("--- 1. Reference Type vs Object Type ---");

        // Reference type: Payment, Object type: CreditCardPayment
        Payment payment1 = new CreditCardPayment(100.00, "4532015112830366");

        // Reference type: Payment, Object type: UPIPayment
        Payment payment2 = new UPIPayment(50.00, "john@upi");

        // Both are "Payment" references, but different objects
        System.out.println("payment1 reference type: Payment");
        System.out.println("payment1 actual object: " + payment1.getClass().getSimpleName());
        System.out.println();
        System.out.println("payment2 reference type: Payment");
        System.out.println("payment2 actual object: " + payment2.getClass().getSimpleName());

        // 2. The Magic: Same method call, different behavior
        System.out.println("\n--- 2. Same Method Call, Different Behavior ---");

        payment1.process();  // Runs CreditCardPayment's process()
        System.out.println();
        payment2.process();  // Runs UPIPayment's process()

        // 3. Why is this useful? Polymorphic method parameter
        System.out.println("\n--- 3. Polymorphic Method Parameter ---");

        // One method handles ALL payment types!
        processAnyPayment(payment1);
        System.out.println();
        processAnyPayment(payment2);

        // 4. Polymorphic Array
        System.out.println("\n--- 4. Polymorphic Array ---");

        Payment[] payments = {
            new CreditCardPayment(200.00, "1234567890123456"),
            new UPIPayment(75.00, "seller@upi"),
            new NetbankingPayment(500.00, "HDFC", "ACC123456")
        };

        // Process all payments with ONE loop
        double total = 0;
        for (Payment p : payments) {
            System.out.println("Processing: " + p.getClass().getSimpleName());
            p.process();
            total += p.getTotal();
            System.out.println();
        }
        System.out.println("Total amount processed: $" + total);

        // 5. Key Insight: Compile-time vs Runtime
        System.out.println("\n--- 5. Key Insight ---");
        System.out.println("Compile-time: Compiler checks if Payment has process() method");
        System.out.println("Runtime: JVM calls the ACTUAL object's process() method");
        System.out.println("\nThis is why it's called DYNAMIC dispatch - decided at runtime!");
    }

    /**
     * This method accepts ANY Payment type - that's the power of polymorphism!
     * We don't need separate methods for CreditCard, UPI, Netbanking, etc.
     */
    public static void processAnyPayment(Payment payment) {
        System.out.println("Processing payment of $" + payment.getAmount());
        System.out.println("Fee: $" + payment.calculateFee());
        System.out.println("Total: $" + payment.getTotal());
        payment.process();
    }
}
