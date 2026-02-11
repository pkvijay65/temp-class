package finaldemo;

import java.util.ArrayList;
import java.util.List;

/**
 * LEARNING OUTCOME: Final Keyword - Complete Demo
 *
 * Run this to see all final concepts in action:
 * 1. Final Variables (cannot reassign)
 * 2. Final Methods (cannot override)
 * 3. Final Classes (cannot extend)
 */
public class FinalDemo {

    public static void main(String[] args) {
        System.out.println("=== Final Keyword Demo ===\n");

        // 1. Final Variables
        System.out.println("--- Final Variables ---");
        final int MAX_VALUE = 100;
        System.out.println("final int MAX_VALUE = " + MAX_VALUE);
        // MAX_VALUE = 200;  // ERROR: Cannot reassign final variable

        // 2. Final with Reference Types
        System.out.println("\n--- Final with Reference Types ---");
        final List<String> names = new ArrayList<>();
        names.add("Alice");   // OK - modifying content
        names.add("Bob");     // OK - modifying content
        System.out.println("names = " + names);
        // names = new ArrayList<>();  // ERROR: Cannot reassign reference

        System.out.println("Key: final prevents REASSIGNMENT, not MODIFICATION of content");

        // 3. Final Methods
        System.out.println("\n--- Final Methods ---");
        System.out.println("See FinalMethods.java for example");
        System.out.println("final void critical() { } // Cannot be overridden in child class");

        // 4. Final Classes
        System.out.println("\n--- Final Classes ---");
        System.out.println("See FinalClasses.java for example");
        System.out.println("final class Utility { } // Cannot be extended");
        System.out.println("Java's final classes: String, Integer, Math, System");

        // 5. Quick Reference
        System.out.println("\n--- Quick Reference ---");
        System.out.println("final variable  -> Cannot reassign");
        System.out.println("final method    -> Cannot override");
        System.out.println("final class     -> Cannot extend");
        System.out.println("static final    -> TRUE CONSTANT (shared + unchangeable)");
    }
}
