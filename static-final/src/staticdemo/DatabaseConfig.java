package staticdemo;

/**
 * Demonstrates static blocks for complex initialization.
 * Static blocks run ONCE when the class is first loaded.
 */
public class DatabaseConfig {
    // Static variables to be initialized
    private static String connectionString;
    private static int maxConnections;
    private static boolean initialized = false;

    // Static block - runs when class is loaded
    static {
        System.out.println("[Static Block 1] Loading database configuration...");
        // Simulate reading from config file or environment
        connectionString = loadConnectionString();
        System.out.println("[Static Block 1] Connection string loaded");
    }

    // Multiple static blocks are allowed - run in order
    static {
        System.out.println("[Static Block 2] Setting up connection pool...");
        maxConnections = calculateMaxConnections();
        initialized = true;
        System.out.println("[Static Block 2] Configuration complete!");
    }

    // Private helper methods called from static block
    private static String loadConnectionString() {
        // In real app, this might read from file or environment
        return "jdbc:mysql://localhost:3306/mydb";
    }

    private static int calculateMaxConnections() {
        // In real app, this might depend on system resources
        return Runtime.getRuntime().availableProcessors() * 2;
    }

    // Static methods to access configuration
    public static String getConnectionString() {
        return connectionString;
    }

    public static int getMaxConnections() {
        return maxConnections;
    }

    public static boolean isInitialized() {
        return initialized;
    }

    // Instance method (for demonstration)
    public void showConfig() {
        System.out.println("Connection: " + connectionString);
        System.out.println("Max Connections: " + maxConnections);
    }
}
