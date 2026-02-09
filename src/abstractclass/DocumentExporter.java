package abstractclass;

/**
 * Demonstrates Template Method Pattern using abstract class.
 * The export() method defines the algorithm skeleton,
 * while format() is customized by subclasses.
 */
public abstract class DocumentExporter {
    protected String content;
    protected String author;

    public DocumentExporter(String content, String author) {
        this.content = content;
        this.author = author;
    }

    // Template method - defines the algorithm skeleton
    // Made final to prevent subclasses from changing the algorithm
    public final void export(String filename) {
        System.out.println("Starting export to: " + filename);

        validate();                        // Step 1: Validate (concrete)
        String formatted = format();       // Step 2: Format (abstract - varies)
        addMetadata();                     // Step 3: Add metadata (concrete)
        write(filename, formatted);        // Step 4: Write (concrete)
        log(filename);                     // Step 5: Log (concrete)

        System.out.println("Export completed!");
    }

    // Concrete method - same for all exporters
    private void validate() {
        if (content == null || content.isEmpty()) {
            throw new IllegalArgumentException("Content cannot be empty");
        }
        System.out.println("✓ Content validated");
    }

    // Abstract method - each exporter formats differently
    protected abstract String format();

    // Hook method - can be overridden, but has default behavior
    protected void addMetadata() {
        System.out.println("✓ Added metadata: author=" + author);
    }

    // Concrete method
    private void write(String filename, String data) {
        System.out.println("✓ Writing " + data.length() + " characters to " + filename);
    }

    // Concrete method
    private void log(String filename) {
        System.out.println("✓ Logged export of " + filename);
    }
}
