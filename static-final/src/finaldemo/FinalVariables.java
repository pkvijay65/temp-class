package finaldemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Final Variables Demo
 * - Primitive vs Reference types
 * - Blank final variables
 * - Static final (constants)
 */
public class FinalVariables {

    // ==================== FINAL PRIMITIVE ====================
    final int MAX_ATTEMPTS = 3;           // Must initialize here
    final double PI = 3.14159;

    // ==================== BLANK FINAL (initialized in constructor) ====================
    final String userId;
    final int createdAt;

    public FinalVariables(String userId) {
        this.userId = userId;                    // OK - first assignment
        this.createdAt = (int) System.currentTimeMillis();
    }

    // ==================== STATIC FINAL (TRUE CONSTANTS) ====================
    public static final int MAX_USERS = 1000;
    public static final String APP_NAME = "MyApp";
    public static final double TAX_RATE = 0.18;

    // ==================== FINAL REFERENCE TYPE ====================
    final List<String> items = new ArrayList<>();

    public void demonstrateFinalReference() {
        // Can MODIFY the object's contents
        items.add("Item 1");      // OK
        items.add("Item 2");      // OK
        items.clear();            // OK - modifying content

        // Cannot REASSIGN the reference
        // items = new ArrayList<>();  // ERROR! Cannot reassign final reference
    }

    // ==================== FINAL METHOD PARAMETERS ====================
    public void process(final String input) {
        // input = "modified";  // ERROR! Cannot reassign final parameter
        System.out.println(input.toUpperCase());  // OK - using the value
    }

    // ==================== FINAL LOCAL VARIABLES ====================
    public void calculateDiscount(double price) {
        final double DISCOUNT_RATE = 0.10;  // Local constant
        // DISCOUNT_RATE = 0.20;  // ERROR! Cannot reassign

        double discount = price * DISCOUNT_RATE;
        System.out.println("Discount: " + discount);
    }

    public static void main(String[] args) {
        FinalVariables demo = new FinalVariables("user123");

        System.out.println("=== Final Primitive ===");
        System.out.println("MAX_ATTEMPTS: " + demo.MAX_ATTEMPTS);
        // demo.MAX_ATTEMPTS = 5;  // ERROR!

        System.out.println("\n=== Blank Final ===");
        System.out.println("User ID: " + demo.userId);
        // demo.userId = "newId";  // ERROR!

        System.out.println("\n=== Static Final (Constants) ===");
        System.out.println("MAX_USERS: " + FinalVariables.MAX_USERS);
        System.out.println("APP_NAME: " + FinalVariables.APP_NAME);

        System.out.println("\n=== Final Reference ===");
        demo.demonstrateFinalReference();
        System.out.println("Items can be modified: " + demo.items);

        System.out.println("\n=== Final Parameters ===");
        demo.process("hello");

        System.out.println("\n=== Final Local Variables ===");
        demo.calculateDiscount(100.0);
    }
}
