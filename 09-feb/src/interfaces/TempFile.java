package interfaces;

/**
 * Example class implementing marker interface.
 */
public class TempFile implements Deletable {
    private String filename;
    private String content;

    public TempFile(String filename) {
        this.filename = filename;
        this.content = "";
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFilename() {
        return filename;
    }

    @Override
    public String toString() {
        return "TempFile{" + filename + "}";
    }
}
