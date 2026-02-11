package interfaces;

/**
 * LEARNING OUTCOME: Default Method Conflict Resolution
 *
 * When a class implements two interfaces that have the SAME default method,
 * the compiler forces you to override and resolve the conflict manually.
 */

// Two interfaces with the same default method signature
interface Logger {
    default void log(String msg) {
        System.out.println("[Logger] " + msg);
    }
}

interface Auditor {
    default void log(String msg) {
        System.out.println("[Auditor] " + msg);
    }
}

// This class MUST override log() to resolve the conflict
class AuditedLogger implements Logger, Auditor {

    @Override
    public void log(String msg) {
        // Option 1: Choose one interface's implementation
        Logger.super.log(msg);

        // Option 2: Choose the other interface's implementation
        // Auditor.super.log(msg);

        // Option 3: Provide completely new implementation
        // System.out.println("[AuditedLogger] " + msg);

        // Option 4: Call both (if that makes sense for your use case)
        // Logger.super.log(msg);
        // Auditor.super.log(msg);
    }
}

// Demo
class DefaultMethodConflictDemo {
    public static void main(String[] args) {
        AuditedLogger logger = new AuditedLogger();
        logger.log("User logged in");  // Uses Logger's implementation
    }
}
