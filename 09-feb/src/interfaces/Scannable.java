package interfaces;

/**
 * Interface for scanning capability.
 */
public interface Scannable {
    String scan();

    default String scanWithResolution(int dpi) {
        System.out.println("Scanning at " + dpi + " DPI...");
        return scan();
    }
}
