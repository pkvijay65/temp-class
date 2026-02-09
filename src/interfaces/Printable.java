package interfaces;

/**
 * Simple interface for printable devices.
 */
public interface Printable {
    void print(String document);

    default void printMultiple(String document, int copies) {
        for (int i = 1; i <= copies; i++) {
            System.out.println("Printing copy " + i + " of " + copies);
            print(document);
        }
    }
}
