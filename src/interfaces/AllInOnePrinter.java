package interfaces;

/**
 * Demonstrates multiple interface implementation.
 * A single class with multiple capabilities.
 */
public class AllInOnePrinter implements Printable, Scannable, Faxable {
    private String modelName;

    public AllInOnePrinter(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public void print(String document) {
        System.out.println("[" + modelName + "] Printing: " + document);
    }

    @Override
    public String scan() {
        System.out.println("[" + modelName + "] Scanning document...");
        return "Scanned content from " + modelName;
    }

    @Override
    public void fax(String document, String faxNumber) {
        System.out.println("[" + modelName + "] Faxing to " + faxNumber + ": " + document);
    }

    // Device-specific method
    public void selfTest() {
        System.out.println("[" + modelName + "] Running self-test...");
        print("Test Page");
        scan();
        System.out.println("Self-test complete!");
    }
}
