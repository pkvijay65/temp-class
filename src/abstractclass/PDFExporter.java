package abstractclass;

/**
 * PDF implementation of DocumentExporter.
 */
public class PDFExporter extends DocumentExporter {

    public PDFExporter(String content, String author) {
        super(content, author);
    }

    @Override
    protected String format() {
        System.out.println("  Formatting as PDF...");
        return "%PDF-1.4\n" +
               "% " + author + "\n" +
               content +
               "\n%%EOF";
    }

    @Override
    protected void addMetadata() {
        super.addMetadata(); // Call parent's implementation
        System.out.println("✓ Added PDF-specific metadata: compression=true");
    }
}
