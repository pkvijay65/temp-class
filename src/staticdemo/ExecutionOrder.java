package staticdemo;

/**
 * Demonstrates execution order of:
 * 1. Static blocks
 * 2. Instance blocks (initializer blocks)
 * 3. Constructors
 */
public class ExecutionOrder {
    // Static variable
    private static int staticVar;

    // Instance variable
    private int instanceVar;

    // Static block - runs ONCE when class is loaded
    static {
        System.out.println("1. Static block executed");
        staticVar = 10;
    }

    // Instance block (initializer block) - runs EVERY time an object is created
    {
        System.out.println("2. Instance block executed");
        instanceVar = 20;
    }

    // Constructor - runs EVERY time an object is created (after instance block)
    public ExecutionOrder() {
        System.out.println("3. Constructor executed");
        System.out.println("   staticVar = " + staticVar + ", instanceVar = " + instanceVar);
    }

    // Another static block (multiple allowed)
    static {
        System.out.println("1b. Second static block executed");
    }

    // Another instance block
    {
        System.out.println("2b. Second instance block executed");
    }

    public static void main(String[] args) {
        System.out.println("=== Execution Order Demo ===\n");
        System.out.println("--- Main method starts ---");

        System.out.println("\n--- Creating first object ---");
        ExecutionOrder obj1 = new ExecutionOrder();

        System.out.println("\n--- Creating second object ---");
        ExecutionOrder obj2 = new ExecutionOrder();

        System.out.println("\n--- Notice: Static blocks ran only ONCE! ---");
    }
}
