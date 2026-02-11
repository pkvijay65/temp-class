package staticdemo;

/**
 * Demonstrates the difference between instance and static variables.
 */
public class Counter {
    private int instanceCount = 0;

    // Static variable - shared across all Counter objects
    private static int staticCount = 0;

    public void increment() {
        instanceCount++;
        staticCount++;
    }

    public void displayCounts() {
        System.out.println("Instance count: " + instanceCount +
                ", Static count: " + staticCount);
    }

    public static int getStaticCount() {
        return staticCount;
    }

    public static void resetStaticCount() {
        staticCount = 0;
    }
}
