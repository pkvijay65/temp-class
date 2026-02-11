package polymorphism.overriding.document;

/**
 * LEARNING OUTCOME: Covariant Return Type
 *
 * When overriding, you can return a more specific type than the parent.
 * Parent returns Document, child can return PDFDocument.
 */
public class PDFDocument extends Document {

    @Override
    public PDFDocument duplicate() {
        System.out.println("PDF duplicated");
        return new PDFDocument();  // Covariant return - more specific type
    }
}
