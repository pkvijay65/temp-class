package interfaces;

/**
 * Basic printer that only implements Printable.
 * Demonstrates that not all classes need all interfaces.
 */
public class BasicPrinter implements Printable {
    private String modelName;

    public BasicPrinter(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public void print(String document) {
        System.out.println("[" + modelName + "] Printing: " + document);
    }
}
