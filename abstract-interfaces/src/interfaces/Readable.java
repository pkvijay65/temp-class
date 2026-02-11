package interfaces;

/**
 * LEARNING OUTCOME: Interface Inheritance
 *
 * Key points:
 * - Interface can extend other interfaces using 'extends'
 * - Interface can extend MULTIPLE interfaces (unlike classes)
 * - Implementing class must implement ALL methods from the chain
 */
public interface Readable {
    String read();
}

interface Writable {
    void write(String data);
}

// Interface extending multiple interfaces
interface ReadWritable extends Readable, Writable {
    // Additional method specific to read-write operations
    void readAndWrite(String input, String output);

    // Default implementation using inherited methods
    default void copy() {
        String data = read();
        write(data);
    }
}
