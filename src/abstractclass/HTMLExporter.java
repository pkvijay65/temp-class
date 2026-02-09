package abstractclass;

/**
 * HTML implementation of DocumentExporter.
 */
public class HTMLExporter extends DocumentExporter {

    private String cssStyle;

    public HTMLExporter(String content, String author) {
        super(content, author);
        this.cssStyle = "body { font-family: Arial; }";
    }

    public HTMLExporter(String content, String author, String cssStyle) {
        super(content, author);
        this.cssStyle = cssStyle;
    }

    @Override
    protected String format() {
        System.out.println("  Formatting as HTML...");
        return "<!DOCTYPE html>\n" +
               "<html>\n" +
               "<head>\n" +
               "  <meta author=\"" + author + "\">\n" +
               "  <style>" + cssStyle + "</style>\n" +
               "</head>\n" +
               "<body>\n" +
               content + "\n" +
               "</body>\n" +
               "</html>";
    }
}
