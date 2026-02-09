package staticdemo;

/**
 * Demonstrates that static methods are HIDDEN, not overridden.
 * This is a common interview question.
 */
class Parent {
    // Static method
    public static void staticMethod() {
        System.out.println("Parent's static method");
    }

    // Instance method
    public void instanceMethod() {
        System.out.println("Parent's instance method");
    }
}

class Child extends Parent {
    // This HIDES parent's static method (not override!)
    public static void staticMethod() {
        System.out.println("Child's static method");
    }

    // This OVERRIDES parent's instance method
    @Override
    public void instanceMethod() {
        System.out.println("Child's instance method");
    }
}

public class MethodHiding {
    public static void main(String[] args) {
        System.out.println("=== Static Method Hiding vs Instance Method Overriding ===\n");

        // Reference type: Parent, Object type: Child
        Parent p = new Child();

        System.out.println("--- Static method (method hiding) ---");
        p.staticMethod();  // Calls Parent's version! (resolved at compile time)
        System.out.println("Reference type determines which static method runs");

        System.out.println("\n--- Instance method (method overriding) ---");
        p.instanceMethod();  // Calls Child's version! (resolved at runtime)
        System.out.println("Object type determines which instance method runs");

        System.out.println("\n--- Calling directly on classes ---");
        Parent.staticMethod();  // Parent's version
        Child.staticMethod();   // Child's version

        System.out.println("\n--- Key Takeaway ---");
        System.out.println("Static methods: Compile-time binding (reference type)");
        System.out.println("Instance methods: Runtime binding (object type)");
    }
}
